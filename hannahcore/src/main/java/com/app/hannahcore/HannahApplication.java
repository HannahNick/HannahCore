package com.app.hannahcore;

import android.app.Application;

/**
 * Created by Nick on 2019-04-26.
 */
public abstract class HannahApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    protected abstract void init();
}
