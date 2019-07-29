package com.app.hannahcore.manager.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Nick on 2019-04-26.
 */
public class GlideManager {

    public static GlideManager getInstance() {
        return Holder.sManager;
    }

    public void loadUrl(Context context, ImageView iv, Object url) {
        if (url==null) {
            return;
        }
        GlideApp.with(context)
                .load(url)
                .into(iv);
    }

    public void loadWithErrorAndPlaceUrl(Context context, ImageView iv, Object url) {
        if (url==null) {
            return;
        }
        GlideApp.with(context)
                .load(url)
//                .placeholder()
//                .error()
                .into(iv);
    }

    public void loadUrlCircle(Context context, ImageView iv, String url) {
        if (url==null) {
            return;
        }
        GlideApp.with(context)
                .load(url)
                .transform(new GlideCircleTransform())
                .into(iv);
    }

    private static class Holder{
        private static final GlideManager sManager = new GlideManager();
    }
}
