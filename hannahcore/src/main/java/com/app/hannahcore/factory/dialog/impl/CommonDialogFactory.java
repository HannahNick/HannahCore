package com.app.hannahcore.factory.dialog.impl;

import android.content.Context;

import com.app.hannahcore.factory.dialog.CustomDialog;
import com.app.hannahcore.factory.dialog.DialogFactory;
import com.app.hannahcore.factory.dialog.config.DialogConfig;

/**
 * Created by Nick on 2019-07-29.
 */
public class CommonDialogFactory extends DialogFactory {

    private CommonDialogFactory(){}

    public static CommonDialogFactory getInstance(){
        return Holder.sFactory;
    }

    @Override
    public CustomDialog createDialog(Context context,DialogConfig config) {
        CommonDialog dialog = new CommonDialog(context);
        dialog.setConfig(config);
        return dialog;
    }

    private static final class Holder{
        private static final CommonDialogFactory sFactory = new CommonDialogFactory();
    }
}
