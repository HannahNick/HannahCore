package com.app.androidutildemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ColorUtils;

/**
 * Created by Nick on 2019/4/18.
 */
public abstract class SimpleBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentView());
        init();
        BarUtils.setStatusBarLightMode(this,true);
        BarUtils.setStatusBarColor(this, ColorUtils.getRandomColor());
    }

    protected abstract int contentView();
    protected abstract void init();
}
