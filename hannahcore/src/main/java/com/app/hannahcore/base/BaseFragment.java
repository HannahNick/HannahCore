package com.app.hannahcore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nick on 2019-04-30.
 */
public abstract class BaseFragment extends Fragment {

    protected boolean mIsVisible;//是否可见
    protected boolean mIsFirstInit = true;//是否第一次初始化

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(),container,false);
        findViews(view);
        initListener();
        if (!shouldLazyLoad()){//无需懒加载的话就直接初始化
            init();
        }
        return view;
    }
    /**
     * 设置对应的布局
     */
    protected abstract int setLayout();
    /**
     * 初始化控件
     */
    protected abstract void findViews(View view);
    /**
     * 初始化除了控件以外的其他数据
     */
    protected abstract void init();
    /**
     * 初始化各种控件的事件响应
     */
    protected abstract void initListener();
    /**
     * 释放内存、解决内存泄漏
     */
    protected abstract void release();

    @Override
    public void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            mIsVisible = true;
            checkLazyLoad();
            handleResume();
        } else {
            mIsVisible = false;
        }
    }

    /**
     * 可见时处理逻辑
     */
    protected void checkLazyLoad(){
        if(mIsFirstInit&&mIsVisible&&shouldLazyLoad()) {//首次加载页面而且可看见而且要懒加载
            init();
            mIsFirstInit = false;
        }
    }

    /**
     * 由业务层决定当前页面是否懒加载
     */
    protected abstract boolean shouldLazyLoad();

    /**
     * 当前页面可见时处理逻辑
     */
    protected abstract void handleResume();
}
