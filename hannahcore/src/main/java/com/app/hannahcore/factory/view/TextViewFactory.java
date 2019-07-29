package com.app.hannahcore.factory.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;

import java.lang.reflect.Constructor;


/**
 * Created by Nick on 2019-07-29.
 */
public class TextViewFactory extends ViewFactory {

    public static TextViewFactory getInstance(){
        return Holder.sFactory;
    }

    @Override
    public <T extends View> T createView(Class<T> clz,Context context) {
        View view;
        try {
            Class<T> aClass = (Class<T>) Class.forName(clz.getName());
            Constructor<T> constructor = aClass.getConstructor(Context.class);
            view = constructor.newInstance(context);
        } catch (Exception e){
            LogUtils.e(e.getMessage());
            view = new TextView(context);
        }
        return (T) view;
    }

    private static class Holder{
        private static final TextViewFactory sFactory = new TextViewFactory();
    }
}
