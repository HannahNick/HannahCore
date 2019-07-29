package com.app.hannahcore.factory.dialog;

import android.view.View;

/**
 * Created by Nick on 2019-07-29.
 * 自定义弹窗接口
 */
public interface CustomDialog {
    /**
     * 弹出弹窗
     */
    void show();

    /**
     * 弹窗消失
     */
    void dismiss();

    /**
     * 获取根布局
     * 可用于findView
     * @return 页面布局
     */
    View getHolderView();


}
