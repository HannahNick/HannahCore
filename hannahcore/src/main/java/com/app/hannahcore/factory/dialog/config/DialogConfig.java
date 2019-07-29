package com.app.hannahcore.factory.dialog.config;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;

import com.app.hannahcore.R;

/**
 * Created by Nick on 2019-07-29.
 */
public class DialogConfig {

    /**
     * 上下文
     */
    private Context context;
    /**
     * 渐变值 0~1f
     */
    private float alpha;
    /**
     * 能不能点击干掉窗体
     */
    private boolean cancelable;
    /**
     * 点击窗体外部可以干掉窗体
     */
    private boolean canceledOnTouchOutside;
    /**
     * 布局
     */
    private View contentViewRes;
    /**
     * 显示位置
     */
    private int gravity;
    /**
     * 弹出动画
     */
    private int animStyleRes;


    private DialogConfig(){}

    public Context getContext() {
        return context;
    }

    public float getAlpha() {
        return alpha;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public boolean isCanceledOnTouchOutside() {
        return canceledOnTouchOutside;
    }

    public View getContentViewRes() {
        return contentViewRes;
    }

    public int getGravity() {
        return gravity;
    }

    public int getAnimStyleRes() {
        return animStyleRes;
    }

    public static class Builder{
        private Context context;
        private float alpha = 1f;
        private boolean cancelable = true;
        private boolean canceledOnTouchOutside = true;
        private View contentViewRes;
        private int animStyleRes = 0;
        private int gravity = Gravity.CENTER;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setAlpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.canceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public Builder setContentViewRes(View contentViewRes) {
            this.contentViewRes = contentViewRes;
            return this;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setAnimStyleRes(@StyleRes int animStyleRes) {
            this.animStyleRes = animStyleRes;
            return this;
        }

        private void applyConfig(DialogConfig dialogConfig){
            dialogConfig.context = this.context;
            dialogConfig.alpha = this.alpha;
            dialogConfig.cancelable = this.cancelable;
            dialogConfig.canceledOnTouchOutside = this.canceledOnTouchOutside;
            dialogConfig.contentViewRes = this.contentViewRes;
            dialogConfig.gravity = this.gravity;
            dialogConfig.animStyleRes = getAnimationResource(this.gravity,this.animStyleRes);
//            R.style.dialogWindowBottomAnim
        }

        private int getAnimationResource(int gravity, int animStyleRes) {
            switch (gravity) {
                case Gravity.TOP:
                    return animStyleRes ==0 ? R.style.dialogWindowTopAnim : animStyleRes;
                case Gravity.BOTTOM:
                    return animStyleRes ==0 ? R.style.dialogWindowBottomAnim : animStyleRes;
                case Gravity.CENTER:
                    return animStyleRes ==0 ? 0 : animStyleRes;
            }
            return animStyleRes;
        }

        public DialogConfig build(){
            DialogConfig dialogConfig = new DialogConfig();
            applyConfig(dialogConfig);
            return dialogConfig;
        }
    }
}
