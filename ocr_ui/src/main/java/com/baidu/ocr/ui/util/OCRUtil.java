package com.baidu.ocr.ui.util;

import android.app.Activity;
import android.content.Intent;

import com.baidu.ocr.ui.camera.CameraActivity;

/**
 * OCR入口工具
 * Created by Nick on 2019-08-26.
 */
public class OCRUtil {
    public static final int REQUEST_CODE_CAMERA = 102;
    public static final int REQUEST_CODE_BANKCARD = 111;


    public static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;

    private OCRUtil(){}

    /**
     * 身份证拍照
     *
     * @Override
     * protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     *   if (requestCode == OCRUtil.REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
     *       if (data != null) {
     *           String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
     *           String filePath = data.getStringExtra(CameraActivity.KEY_OUTPUT_FILE_PATH);
     *           if (!TextUtils.isEmpty(contentType)) {
     *               if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
     *                  //身份证正面
     *                  Toast.makeText(this, "扫描成功:"+filePath, Toast.LENGTH_SHORT).show();
     *               } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
     *                  //身份证背面
     *               }
     *           }
     *       }
     *   }
     * }
     * @param context 上下文
     * @param path 文件保存路径
     */
    public static void toIdCardActivity(Activity context, String path){
        Intent intent = new Intent(context, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH, path);
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
        context.startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    /**
     * 跳到银行卡拍照
     *
     * if (requestCode == OCRUtil.REQUEST_CODE_BANKCARD && resultCode == Activity.RESULT_OK) {
     *    if (data != null) {
     *      String filePath = data.getStringExtra(CameraActivity.KEY_OUTPUT_FILE_PATH);
     *      Toast.makeText(this, "银行卡扫描成功:"+bankCardPath, Toast.LENGTH_SHORT).show();
     *    }
     * }
     * @param context 上下文
     * @param path 文件保存路径
     */
    public static void toBankCardActivity(Activity context,String path){
        Intent intent = new Intent(context, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH, path);
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_BANK_CARD);
        context.startActivityForResult(intent, REQUEST_CODE_BANKCARD);
    }

}
