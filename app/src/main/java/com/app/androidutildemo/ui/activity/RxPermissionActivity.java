package com.app.androidutildemo.ui.activity;

import android.Manifest;
import android.widget.Button;
import android.widget.Toast;

import com.app.androidutildemo.R;
import com.app.hannahcore.aop.TimeLog;
import com.app.hannahcore.base.BaseActivity;
import com.app.hannahcore.base.BasePresenter;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;

import java.util.List;

public class RxPermissionActivity extends BaseActivity {


    private Button mBtn_get_permission;

    @Override
    protected int setLayout() {
        return R.layout.activity_rx_permission;
    }

    @Override
    protected void findViews() {
        mBtn_get_permission=findViewById(R.id.btn_get_permission);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {
        mBtn_get_permission.setOnClickListener(v -> {
            boolean granted = PermissionUtils.isGranted(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_CONTACTS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECORD_AUDIO);
            if (!granted){
                PermissionUtils.permission(PermissionConstants.CAMERA,PermissionConstants.PHONE,
                        PermissionConstants.STORAGE,PermissionConstants.LOCATION,PermissionConstants.SMS,PermissionConstants.MICROPHONE)
                        .callback(new PermissionUtils.SimpleCallback() {
                            @Override
                            public void onGranted() {
                                Toast.makeText(RxPermissionActivity.this, "获取到全部权限", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onDenied() {
                                Toast.makeText(RxPermissionActivity.this, "获取权限被拒绝", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .callback(new PermissionUtils.FullCallback() {
                            @Override
                            public void onGranted(List<String> permissionsGranted) {
                                LogUtils.e("permissionsGranted"+permissionsGranted.toString());
                            }

                            @Override
                            public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                                LogUtils.e("permissionsDeniedForever"+permissionsDeniedForever.toString());
                                LogUtils.e("permissionsDenied"+permissionsDenied.toString());
                            }
                        })
                        .request();
            }
            Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void release() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @TimeLog
    private void appTime(){
        for (int i = 0; i < 100; i++) {

        }
        LogUtils.i("方法执行结束");
    }
}
