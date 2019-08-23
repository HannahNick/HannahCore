package com.app.updateutil;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.app.hannahcore.factory.dialog.CustomDialog;
import com.app.hannahcore.factory.dialog.config.DialogConfig;
import com.app.hannahcore.factory.dialog.config.DialogConfig.Builder;
import com.app.hannahcore.factory.dialog.impl.CommonDialogFactory;
import com.app.hannahcore.manager.file.FileDownLoadManager;
import com.app.hannahcore.manager.file.FileDownLoadManager.SimpleListener;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PermissionUtils.SimpleCallback;

import java.io.File;

/**
 * Created by Nick on 2019-05-06.
 */
public class UpdateAppUtil {

    private static final String TAG = "UpdateAppUtil";
    public static final int CHECK_BY_VERSION_NAME = 1001;
    public static final int CHECK_BY_VERSION_CODE = 1002;
    public static final int DOWNLOAD_BY_APP = 1003;
    public static final int DOWNLOAD_BY_BROWSER = 1004;
    public static final int GET_UNKNOWN_APP_SOURCES_REQUEST_CODE = 10086;
    public static final String DENIED = "denied";

    private Activity mActivity;
    private String mUrl ="";//apk服务器地址
    private int mServerVersionCode = 0;//服务器记录的版本号
    private String mServerVersionName ="";//服务器记录的版本名
    private int mLocalVersionCode = 0;//当前应用版本号
    private String mLocalVersionName ="";//当前应用版本名
    private String mTitle ="";//更新标题
    private String mVersionContent ="";//更新内容
    private boolean mIsForce = false; //是否强制更新
    private String mFileName;//文件名
    private int mDownloadBy = DOWNLOAD_BY_APP;//下载类型,默认通过app自己下载
    private String mLocalPath = PathUtils.getExternalDownloadsPath();//apk存储路径
    private int mCheckBy;//版本差异判断类型,通过版本号或者版本名判断
    private SimpleListener mDownloadCallBack;//下载回调
    private View mConfirmUpdateLayout;//更新的提示弹窗布局
    private CustomDialog mConfirmRxDialog;//更新弹窗


    private UpdateAppUtil(Activity activity) {
        this.mActivity = activity;
        getAPPLocalVersion();
    }

    public static UpdateAppUtil from(Activity activity){
        return new UpdateAppUtil(activity);
    }

    public UpdateAppUtil checkBy(int checkBy){
        mCheckBy = checkBy;
        return this;
    }

    public UpdateAppUtil urlPath(String apkPath){
        this.mUrl = apkPath;
        return this;
    }

    public UpdateAppUtil downloadBy(int downloadBy){
        this.mDownloadBy = downloadBy;
        return this;
    }

    public UpdateAppUtil serverVersionCode(int serverVersionCode){
        this.mServerVersionCode = serverVersionCode;
        return this;
    }

    public UpdateAppUtil serverVersionName(String  serverVersionName){
        this.mServerVersionName = serverVersionName;
        return this;
    }

    public UpdateAppUtil titleContent(String titleContent){
        this.mTitle = titleContent;
        return this;
    }

    public UpdateAppUtil versionContent(String versionContent){
        this.mVersionContent = versionContent;
        return this;
    }

    public UpdateAppUtil isForce(boolean  isForce){
        this.mIsForce = isForce;
        return this;
    }

    public UpdateAppUtil setFileName(String fileName){
        this.mFileName = fileName;
        return this;
    }

    public UpdateAppUtil setCallBackListener(SimpleListener listener){
        this.mDownloadCallBack = listener;
        return this;
    }

    public UpdateAppUtil setDialogLayout(View view){
        this.mConfirmUpdateLayout = view;
        return this;
    }

    //获取apk的版本号 currentVersionCode
    private void getAPPLocalVersion() {
        mLocalVersionName = AppUtils.getAppVersionName(); // 版本名
        mLocalVersionCode = AppUtils.getAppVersionCode(); // 版本号
    }

    //初始化更新提示弹窗
    private void initUpdateDialog(){
        DialogConfig config = new Builder()
                .setGravity(Gravity.CENTER)
                .setContext(mActivity)
                .setCancelable(!mIsForce)
                .setCanceledOnTouchOutside(!mIsForce)
                .setContentViewRes(mConfirmUpdateLayout)
                .build();
        mConfirmRxDialog = CommonDialogFactory.getInstance().createDialog(mActivity, config);

        TextView title= mConfirmUpdateLayout.findViewById(R.id.update_title);
        TextView content = mConfirmUpdateLayout.findViewById(R.id.update_content);
        TextView cancel = mConfirmUpdateLayout.findViewById(R.id.update_cancel);
        TextView confirm = mConfirmUpdateLayout.findViewById(R.id.update_confirm);
        title.setText(mTitle);
        if (mIsForce){
            mVersionContent = mVersionContent.concat("\n您当前版本太旧需要更新后才可使用");
        }
        content.setText(mVersionContent);
        cancel.setOnClickListener(v -> {
            mConfirmRxDialog.dismiss();
            if (mIsForce){
                mActivity.finish();
            }
        });
        confirm.setOnClickListener(v -> {
            mConfirmRxDialog.dismiss();
            checkPermission();
        });
    }


    /**
     * 检查更新
     */
    public void update(){
        initUpdateDialog();
        switch (mCheckBy){
            case CHECK_BY_VERSION_CODE:
                if (mServerVersionCode >mLocalVersionCode){
                    mConfirmRxDialog.show();
                }else {
                    LogUtils.iTag(TAG,"当前版本是最新版本"+mServerVersionCode+"/"+mServerVersionName);
                }
                break;
            case CHECK_BY_VERSION_NAME:
                if (!mServerVersionName.equals(mLocalVersionName)){
                    mConfirmRxDialog.show();
                }else {
                    LogUtils.iTag(TAG,"当前版本是最新版本"+mServerVersionCode+"/"+mServerVersionName);
                }
                break;
        }
    }

    /**
     * 查看是否有下载权限
     */
    private void checkPermission(){
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .callback(new SimpleCallback() {
                    @Override
                    public void onGranted() {
                        downloadApk();
                    }

                    @Override
                    public void onDenied() {
                        if (mIsForce){
                            mActivity.finish();
                        }else {
                            mDownloadCallBack.error(DENIED);
                        }
                    }
                })
                .request();
    }

    /**
     * 下载apk
     */
    private void downloadApk(){
        if (TextUtils.isEmpty(mUrl)){
            LogUtils.eTag(TAG,"下载链接不能为空");
            return;
        }
        if (mDownloadCallBack==null){
            LogUtils.eTag(TAG,"下载回调不能为空");
            return;
        }
        if (TextUtils.isEmpty(mFileName)){
            mFileName = mUrl.substring(mUrl.lastIndexOf("/"));
        }
        File file = new File(mFileName);
        if (FileUtils.isFileExists(file)){
            FileUtils.delete(file);
        }
        FileDownLoadManager.getInstance()
                .simpleDownload(mUrl, mLocalPath.concat(mFileName), mDownloadCallBack);
    }
}
