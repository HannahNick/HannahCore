package com.app.androidutildemo.ui.fragment;

import android.view.View;

import com.app.androidutildemo.R;
import com.app.hannahcore.base.BaseFragment;
import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Nick on 2019-04-22.
 */
public class ShopCartFragment extends BaseFragment {

    @Override
    protected int setLayout() {
        return R.layout.layout_shopcart;
    }

    @Override
    protected void findViews(View view) {

    }

    @Override
    protected void init() {
        LogUtils.e("购物车初始化完成");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void release() {

    }

    @Override
    protected boolean shouldLazyLoad() {
        return true;
    }

    @Override
    protected void handleResume() {
        LogUtils.e("购物车可见");
    }
}
