package com.app.hannahcore.manager.imgpicker;

import android.app.Activity;
import android.widget.ImageView;

import com.app.hannahcore.manager.image.GlideManager;
import com.lzy.imagepicker.loader.ImageLoader;

/**
 * Created by Nick on 2017/11/6.
 * 图片选择器
 */

public class GlideImageLoader implements ImageLoader {


    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        GlideManager.getInstance()
                .loadUrl(activity,imageView,path);
    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        GlideManager.getInstance()
                .loadUrl(activity,imageView,path);
    }

    @Override
    public void clearMemoryCache() {

    }
}
