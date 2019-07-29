package com.app.hannahcore.factory.dialog.impl;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.app.hannahcore.R;
import com.app.hannahcore.factory.dialog.CustomDialog;
import com.app.hannahcore.factory.dialog.config.DialogConfig;

/**
 * Created by Nick on 2019-07-29.
 */
public class CommonDialog extends Dialog implements CustomDialog {

    private DialogConfig mConfig;

    public CommonDialog(@NonNull Context context) {
        super(context);
    }

    public CommonDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public void setConfig(DialogConfig dialogConfig){
        mConfig = dialogConfig;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(dialogConfig.isCancelable());
        setCanceledOnTouchOutside(dialogConfig.isCanceledOnTouchOutside());
        Window window = this.getWindow();
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.height = LayoutParams.WRAP_CONTENT;
            attributes.gravity = dialogConfig.getGravity();
            attributes.alpha = dialogConfig.getAlpha();
        }
        window.setWindowAnimations(dialogConfig.getAnimStyleRes());
        window.setAttributes(attributes);
        setContentView(dialogConfig.getContentViewRes());

    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public View getHolderView() {
        return mConfig.getContentViewRes();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
