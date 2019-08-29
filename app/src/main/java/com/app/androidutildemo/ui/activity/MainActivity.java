package com.app.androidutildemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.Toast;

import com.app.androidutildemo.R;
import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.manager.HttpManager;
import com.app.hannahcore.manager.file.FileDownLoadManager;
import com.app.hannahcore.manager.file.FileDownLoadManager.SimpleListener;
import com.app.hannahcore.manager.network.RequestBodyUtil;
import com.app.hannahcore.utils.NotificationUtil;
import com.app.updateutil.UpdateAppUtil;
import com.app.updateutil.VersionBean.DataBean;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.util.OCRUtil;
import com.baidu.ocr.ui.util.UriUtil;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PermissionUtils.SimpleCallback;
import com.blankj.utilcode.util.ToastUtils;

import java.io.File;
import java.util.WeakHashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;


public class MainActivity extends SimpleBaseActivity {

    public static final String TAG = "nick";
    public static final int REQUEST_CODE = 0x01;
    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_CAMERA = 102;

    @Override
    protected int contentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        Button button = findViewById(R.id.btn_skip);
        button.setOnClickListener(v -> {
//            hasActivity();
//            toActivity();
//            toActivityForResult();
//            getLauncherActivity();
//            startActivities();
//            requestPermission();
//            showCustomToast();
//            startDownload();
//            showNotification();
//            checkVersion();
//            getAllPermission();
//            toIdScanActivity();
            toIdPickActivity();
//            toBankCardActivity();
        });
        setStatusBarLightMode();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == OCRUtil.REQUEST_CODE_PICK_IMAGE_FRONT && resultCode == Activity.RESULT_OK) {
            String filePath = UriUtil.getRealPathFromURI(this,data.getData());
            Toast.makeText(this, "身份证扫描成功:"+filePath, Toast.LENGTH_SHORT).show();
        }
        if (requestCode == OCRUtil.REQUEST_CODE_BANKCARD && resultCode == Activity.RESULT_OK) {
            if (data!=null){
                String bankCardPath = data.getStringExtra(CameraActivity.KEY_OUTPUT_FILE_PATH);
                Toast.makeText(this, "银行卡扫描成功:"+bankCardPath, Toast.LENGTH_SHORT).show();
            }
        }


        if (requestCode == OCRUtil.REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = data.getStringExtra(CameraActivity.KEY_OUTPUT_FILE_PATH);
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        // TODO: 2019-08-22 身份证正面
                        Toast.makeText(this, "扫描成功:"+filePath, Toast.LENGTH_SHORT).show();
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        // TODO: 2019-08-22 身份证背面
                    }
                }
            }
        }
    }

    private void hasActivity(){
        String packageName = getPackageName();
        String name = SecondActivity.class.getName();
        boolean activityExists = ActivityUtils.isActivityExists(packageName, name);
        Log.e(TAG,""+activityExists);

//        ActivityUtils.startActivity(getPackageName(),name);
    }

    private void toActivity(){
        Intent intent = new Intent(this, ThirdActivity.class);
        ActivityUtils.startActivity(intent);
    }

    private void toIdPickActivity(){
        if (PermissionUtils.isGranted(PermissionConstants.STORAGE,PermissionConstants.CAMERA)){
            OCRUtil.toIdCardActivity(this, PathUtils.getExternalDownloadsPath().concat("/pic.jpg"),true,false);
        }else {
            PermissionUtils.permission(PermissionConstants.STORAGE,PermissionConstants.CAMERA)
                    .callback(new SimpleCallback() {
                        @Override
                        public void onGranted() {
                            OCRUtil.toIdCardActivity(MainActivity.this, PathUtils.getExternalDownloadsPath().concat("/pic.jpg"),true,false);
                        }

                        @Override
                        public void onDenied() {

                        }
                    })
                    .request();
        }

    }

    private void toBankCardActivity(){
        OCRUtil.toBankCardActivity(this,PathUtils.getExternalDownloadsPath().concat("/pic.jpg"),true);
    }

    private void toIdScanActivity(){
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                new File(getApplication().getFilesDir(), "pic.jpg").getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_NATIVE_ENABLE,
                true);
        // KEY_NATIVE_MANUAL设置了之后CameraActivity中不再自动初始化和释放模型
        // 请手动使用CameraNativeHelper初始化和释放模型
        // 推荐这样做，可以避免一些activity切换导致的不必要的异常
        intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL,
                true);
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    private void toActivityForResult(){
        ActivityUtils.startActivityForResult(this,SecondActivity.class,REQUEST_CODE);
    }

    private void getLauncherActivity(){
        String launcherActivity = ActivityUtils.getLauncherActivity();
        Log.e(TAG,launcherActivity);
    }

    private void startActivities(){
        Intent[] intents = new Intent[]{
                new Intent(this,SecondActivity.class),
                new Intent(this,ThirdActivity.class),
                new Intent(this,ForthActivity.class),
        };

        ActivityUtils.startActivities(intents);
    }

    //666
    private void setStatusBarLightMode(){
        BarUtils.setStatusBarLightMode(this,true);
//        ColorUtils.int2RgbString(18138168);
    }

    //666
    private void requestPermission(){
//        if (VERSION.SDK_INT >= VERSION_CODES.M) {
//            PermissionUtils.requestWriteSettings(new SimpleCallback() {
//                @Override
//                public void onGranted() {
//                    ToastUtils.showShort("获取到了权限");
//                }
//
//                @Override
//                public void onDenied() {
//                    ToastUtils.showShort("获取权限失败");
//                }
//            });
//        }

//        PermissionUtils.permission(PermissionConstants.STORAGE,
//                PermissionConstants.CAMERA,
//                PermissionConstants.LOCATION,
//                PermissionConstants.CONTACTS,
//                PermissionConstants.PHONE,
//                PermissionConstants.MICROPHONE)
//                .callback(new FullCallback() {
//                    @Override
//                    public void onGranted(List<String> permissionsGranted) {
//                        Log.e(TAG,"获取到权限>>>>"+permissionsGranted.toString());
//                    }
//
//                    @Override
//                    public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
//                        Log.e(TAG,"被拒绝了>>>>"+permissionsDenied.toString());
//                    }
//                }).request();
        PermissionUtils.launchAppDetailsSettings();
    }

    //666
    private void showCustomToast(){
        ToastUtils.setGravity(Gravity.CENTER,0,0);
//        ToastUtils.showShort("中间弹窗");

        ToastUtils.showCustomShort(R.layout.layout_toast);
    }

    private void getAllPermission(){
        PermissionUtils.permission(PermissionConstants.CAMERA,
                PermissionConstants.CONTACTS,
                PermissionConstants.LOCATION,
                PermissionConstants.SMS)
                .request();
    }

    private void startDownload(){
        if (VERSION.SDK_INT >= VERSION_CODES.M) {
            PermissionUtils.requestWriteSettings(new SimpleCallback() {
                @Override
                public void onGranted() {

                }

                @Override
                public void onDenied() {

                }
            });
        }
        PermissionUtils
                .permission(PermissionConstants.STORAGE)
                .callback(new SimpleCallback() {
            @Override
            public void onGranted() {
                NotificationUtil.getInstance().initProgressNotification(MainActivity.this,R.drawable.ic_launcher,"app下载","下载","");
                FileDownLoadManager.getInstance()
                        .simpleDownload("https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/heyguys-V1.14.0-2019.04.29_egu_aligned_signed.apk",
                                PathUtils.getExternalDownloadsPath().concat("/heyguysNick.apk"),
                                new SimpleListener() {
                                    @Override
                                    public void progress(String percent) {
                                        LogUtils.e(percent);
                                        NotificationUtil.getInstance().updateProgress(100,Integer.valueOf(percent),percent);
                                    }

                                    @Override
                                    public void completed(String path) {
                                        LogUtils.e("下载完成>>>"+path);
                                    }

                                    @Override
                                    public void error(String e) {
                                        LogUtils.e(e);
                                    }
                                });

            }
            @Override
            public void onDenied() {

            }
        }).request();
    }

    private void checkUpdate(){

    }


    private void showNotification(){
        Intent intent = new Intent(this,SecondActivity.class);
        NotificationUtil.getInstance().getCommonNotification(this,
                R.drawable.ic_launcher,
                "测试",
                "嘿嘿嘿",
                "升级",
                intent);
    }

    /**
     * 检查更新
     */
    public void checkVersion(){
        WeakHashMap<String,Object> params = new WeakHashMap<>();
        params.put("deviceAppVersion", AppUtils.getAppVersionName());
        params.put("deviceType", "android");
        params.put("softNo", "hhj_cs_app");
        params.put("cityId",100);
        RequestBody requestBody = RequestBodyUtil.getInstance().getRequestBody(params);
        Disposable subscribe = HttpManager.getInstance()
                .getApi()
                .checkVersion(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(versionBean -> {
                    if (versionBean.isSucceed()) {
                        checkSettingPermission(versionBean.getData());
                    }
                }, throwable -> {
                    LogUtils.e(throwable.getMessage());
                });
    }

    private void checkSettingPermission(DataBean versionBean){
        boolean haveNewVersion = versionBean.isHaveNewVersion();
        if (!haveNewVersion){
            return;
        }
        NotificationUtil.getInstance().initProgressNotification(this,
                R.drawable.ic_launcher,
                "文件下载",
                "下载",
                "0%");
        UpdateAppUtil.from(this)
                .checkBy(UpdateAppUtil.CHECK_BY_VERSION_NAME)
                .serverVersionName(versionBean.getDeviceSystemVersion())
                .urlPath(versionBean.getFileURL())
                .isForce(versionBean.isForceUpgrade())
                .titleContent(versionBean.getTitle())
                .versionContent(versionBean.getContent())
                .setDialogLayout(LayoutInflater.from(this).inflate(R.layout.layout_update_dialog,null))
                .setCallBackListener(new SimpleListener() {
                    @Override
                    public void progress(String percent) {
                        NotificationUtil.getInstance()
                                .updateProgress(100,
                                Integer.valueOf(percent),
                                percent);
                    }

                    @Override
                    public void completed(String path) {
                        NotificationUtil.getInstance()
                                .updateProgress(100,
                                        100,
                                        "100");
                        AppUtils.installApp(path);
                        if (versionBean.isForceUpgrade()){
                            finish();
                        }
                    }

                    @Override
                    public void error(String msg) {
                        ToastUtils.showShort("app下载出错了");
                    }
                })
                .update();

    }
}
