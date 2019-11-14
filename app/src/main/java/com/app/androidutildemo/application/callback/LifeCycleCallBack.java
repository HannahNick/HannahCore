package com.app.androidutildemo.application.callback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Nick on 2019-11-13.
 */
public class LifeCycleCallBack implements Application.ActivityLifecycleCallbacks{

    public static final String TAG = "LifeCycleCallBack";


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d(TAG, String.format("onActivityCreated: %1$s",activity.getLocalClassName()));
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d(TAG, String.format("onActivityStarted: %1$s",activity.getLocalClassName()));
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(TAG, String.format("onActivityResumed: %1$s",activity.getLocalClassName()));
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(TAG, String.format("onActivityPaused: %1$s",activity.getLocalClassName()));
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d(TAG, String.format("onActivityStopped: %1$s",activity.getLocalClassName()));
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.d(TAG, String.format("onActivitySaveInstanceState: %1$s",activity.getLocalClassName()));
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d(TAG, String.format("onActivityDestroyed: %1$s",activity.getLocalClassName()));
    }
}
