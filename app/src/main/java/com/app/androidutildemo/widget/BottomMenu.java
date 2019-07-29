package com.app.androidutildemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.androidutildemo.R;


/**
 * Created by Nick on 2017/9/8.
 * 底部菜单栏自定义样式
 */

public class BottomMenu extends LinearLayout {
    View mMenu_view;
    ImageView mIv_menu;
    private TextView mTv_messagenum;
    private int mINorPicId;
    private int mIPressPicId;
    private TranslateAnimation translateAnimation;
    private ScaleAnimation mGrowAnimation;//放大动画
    private ScaleAnimation mShrinkAnimation;//缩小动画
    private int miIspress=0;//定义一个数字变量来确定这个按钮是否按下，0表示未按下

    public BottomMenu(Context context) {
        super(context);
    }

    public BottomMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMenu_view = LayoutInflater.from(context).inflate(R.layout.layout_bottommenu,this,true);

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.BottomMenu);
        mINorPicId = typedArray.getResourceId(R.styleable.BottomMenu_normalpic,0);
        mIPressPicId = typedArray.getResourceId(R.styleable.BottomMenu_presspic,0);

        mIv_menu = mMenu_view.findViewById(R.id.ivmenu);
        mTv_messagenum = mMenu_view.findViewById(R.id.tv_messagenum);
        mIv_menu.setImageResource(mINorPicId);

        //让图片放大
        //图片在x轴上放大1.5倍
        //图片在y轴上放大1.5倍
        //定义缩放的中心点的x轴坐标在自身的中心
        //定义缩放的中心点的y轴坐标在自身的顶部
//        mGrowAnimation = new ScaleAnimation(
//                0.8f,
//                1.1f,//图片在x轴上放大1.1倍
//                0.8f,
//                1.1f,//图片在y轴上放大1.1倍
//                Animation.RELATIVE_TO_SELF,
//                0.5f,//定义缩放的中心点的x轴坐标在自身的中心
//                Animation.RELATIVE_TO_SELF,
//                0.5f//0是定义缩放的中心点的y轴坐标在自身的顶部
//        );
//        mGrowAnimation.setDuration(200);
//        mGrowAnimation.setFillAfter(true);//让动画停留在最后一帧
////        让图片缩小
//        mShrinkAnimation = new ScaleAnimation(
//                1.1f,
//                1f,//图片在x轴上放大1.5倍
//                1.1f,
//                1f,//图片在y轴上放大1.5倍
//                Animation.RELATIVE_TO_SELF,
//                0.5f,//定义缩放的中心点的x轴坐标在自身的中心
//                Animation.RELATIVE_TO_SELF,
//                0.5f//0是定义缩放的中心点的y轴坐标在自身的顶部
//        );
//        mShrinkAnimation.setDuration(200);
//        mShrinkAnimation.setFillAfter(true);//让动画停留在最后一帧
        typedArray.recycle();
    }
    public void onSelect(){
        if (miIspress==0) {
            mIv_menu.setImageResource(mIPressPicId);

            startLayoutAnimation();
            //让文字向下移动
//            translateAnimation = new TranslateAnimation(
//                    Animation.RELATIVE_TO_SELF,
//                    0,
//                    Animation.RELATIVE_TO_SELF,
//                    0,
//                    Animation.RELATIVE_TO_SELF,
//                    0,
//                    Animation.RELATIVE_TO_SELF,
//                    1
//            );
//            translateAnimation.setDuration(100);
//            translateAnimation.setFillAfter(true);//让动画停留在最后一帧
            miIspress=1;
        }
    }
    public void unSelect(){
        if(miIspress==1){
            mIv_menu.setImageResource(mINorPicId);
//            mIv_menu.startAnimation(mShrinkAnimation);
//            mTv_messagenum.startAnimation(mShrinkAnimation);
//            translateAnimation = new TranslateAnimation(
//                    Animation.RELATIVE_TO_SELF,
//                    0,
//                    Animation.RELATIVE_TO_SELF,
//                    0,
//                    Animation.RELATIVE_TO_SELF,
//                    1,
//                    Animation.RELATIVE_TO_SELF,
//                    0
//            );
//            translateAnimation.setDuration(100);
//            translateAnimation.setFillAfter(true);//让动画停留在最后一帧
            miIspress=0;
        }
    }
    public void setMessageNum(int num){
        if (num==0){
            mTv_messagenum.setVisibility(GONE);
        }else if (num>=1&&num<=99){
            mTv_messagenum.setText(String.valueOf(num));
            mTv_messagenum.setVisibility(VISIBLE);
        }else {
            mTv_messagenum.setText("99+");
            mTv_messagenum.setVisibility(VISIBLE);
        }


    }
}
