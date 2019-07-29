package com.app.hannahcore.utils;

import com.app.hannahcore.manager.imgpicker.GlideImageLoader;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;

/**
 * Created by Nick on 2019-05-16.
 */
public class ImageSelectUtil {
    private ImageSelectUtil(){}
    /**
     * 图片选择相关参数设置
     * @param isMultiMode 是否为多图选择
     * @param selectLimit 个数选择
     * @param canCrop 是否裁剪
     */
    public static void imageSelectOption(boolean isMultiMode,int selectLimit,boolean canCrop){
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(canCrop);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(selectLimit);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
        imagePicker.setMultiMode(isMultiMode);//是否为多图选择
    }
}
