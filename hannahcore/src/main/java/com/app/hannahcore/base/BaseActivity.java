package com.app.hannahcore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.app.hannahcore.R;

/**
 * Created by Nick on 2019-04-29.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    /**
     * 顶部toolbar
     */
    protected Toolbar mToolbar;
    protected TextView mToolbarTitle;
    //不显示toolber
    public static final int MODE_NONE = 0;
    //有返回按钮
    public static final int MODE_BACK = 1;

    protected T mPresenter = initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        findViews();
        initListener();
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        release();
        if (mPresenter!=null){
            mPresenter.clear();
        }
    }

    /**
     * 初始化顶部标题栏
     * @param title 标题文字
     */
    protected void setUpToolbar(String title) {
        mToolbar = findViewById(R.id.toolbar);
        mToolbarTitle = findViewById(R.id.toolbar_title);
        mToolbar.setNavigationIcon(R.drawable.arrow_back);
        mToolbar.setNavigationOnClickListener(view -> onNavigationBtnClicked());
        setUpTitle(title);
    }

    /**
     * 顶部标题文字
     * @param title
     */
    protected void setUpTitle(String title) {
        if (mToolbarTitle != null) {
            mToolbarTitle.setText(title);
        }
    }

    /**
     * 顶部标题栏返回
     */
    private void onNavigationBtnClicked() {
        finish();
    }

    /**
     * 设置对应的布局
     */
    protected abstract int setLayout();

    /**
     * 初始化控件
     */
    protected abstract void findViews();

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

    /**
     * 子类需要初始化presenter
     * @return
     */
    protected abstract T initPresenter();
}
