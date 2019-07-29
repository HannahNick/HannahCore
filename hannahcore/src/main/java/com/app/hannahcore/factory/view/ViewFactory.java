package com.app.hannahcore.factory.view;

import android.content.Context;
import android.view.View;

/**
 * Created by Nick on 2019-07-29.
 */
public abstract class ViewFactory {

    public abstract <T extends View> T createView(Class<T> clz, Context context);
}
