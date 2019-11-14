package com.app.androidutildemo.ui.activity;

import android.os.Bundle;

import com.app.androidutildemo.R;
import com.app.androidutildemo.manager.HttpManager;
import com.app.hannahcore.manager.network.RequestBodyUtil;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.WeakHashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class LifeCycleActivity extends RxAppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
    }

    private void initData(){
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
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(versionBean -> {
                    if (versionBean.isSucceed()) {
                    }
                }, throwable -> {
                    LogUtils.e(throwable.getMessage());
                });
    }
}
