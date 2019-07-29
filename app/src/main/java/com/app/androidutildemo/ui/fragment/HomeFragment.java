package com.app.androidutildemo.ui.fragment;

import android.view.View;

import com.app.androidutildemo.R;
import com.app.hannahcore.base.BaseFragment;
import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Nick on 2019-04-22.
 */
public class HomeFragment extends BaseFragment {


    @Override
    protected int setLayout() {
        return R.layout.layout_home;
    }

    @Override
    protected void findViews(View view) {

    }

    @Override
    protected void init() {
        LogUtils.e("首页初始化完成");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void release() {

    }

    @Override
    protected boolean shouldLazyLoad() {
        return false;
    }

    @Override
    protected void handleResume() {
        LogUtils.e("首页可见");
    }
}
