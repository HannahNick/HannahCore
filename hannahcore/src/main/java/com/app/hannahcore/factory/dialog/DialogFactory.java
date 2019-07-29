package com.app.hannahcore.factory.dialog;

import android.content.Context;

import com.app.hannahcore.factory.dialog.config.DialogConfig;

/**
 * Created by Nick on 2019-07-29.
 * 弹窗抽象工厂
 */
public abstract class DialogFactory{

    /**
     * 构建弹窗
     * @param config 弹窗配置
     */
    public abstract CustomDialog createDialog(Context context, DialogConfig config);
}
