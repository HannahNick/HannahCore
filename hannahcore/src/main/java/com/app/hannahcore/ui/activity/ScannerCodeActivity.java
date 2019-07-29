package com.app.hannahcore.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.app.hannahcore.R;
import com.app.hannahcore.scaner.CameraManager;
import com.app.hannahcore.scaner.PlanarYUVLuminanceSource;
import com.app.hannahcore.scaner.decoding.InactivityTimer;
import com.app.hannahcore.scaner.tool.RxQrBarTool;
import com.app.hannahcore.utils.ImageSelectUtil;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PermissionUtils.SimpleCallback;
import com.blankj.utilcode.util.ToastUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


public class ScannerCodeActivity extends AppCompatActivity {

    private InactivityTimer mInactivityTimer;

    /**
     * 扫描处理
     */
    private CaptureActivityHandler mHandler;

    /**
     * 整体根布局
     */
    private RelativeLayout mContainer = null;

    /**
     * 扫描框根布局
     */
    private RelativeLayout mCropLayout = null;

    /**
     * 扫描边界的宽度
     */
    private int mCropWidth = 0;

    /**
     * 扫描边界的高度
     */
    private int mCropHeight = 0;

    /**
     * 是否有预览
     */
    private boolean mHasSurface;

    /**
     * 扫描成功后是否震动
     */
    private boolean mVibrate = true;

    /**
     * 闪光灯开启状态
     */
    private boolean mFlashing = true;

    /**
     * 生成二维码 & 条形码 布局
     */
    private LinearLayout mLlScanHelp;

    /**
     * 闪光灯 按钮
     */
    private ImageView mIvLight;

    public static final int IMGPICKER_REQUEST_CODE = 0x01;
    public static final int RESULT_CODE = 0x99;
    public static final String SCAN_RESULT = "SCAN_RESULT";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_code);
        ImageSelectUtil.imageSelectOption(false,1,false);
        //界面控件初始化
        initDecode();
        initView();
        //权限初始化
        initPermission();
        //扫描动画初始化
        initScannerAnimation();
        //初始化 CameraManager
        CameraManager.init(this);
        mHasSurface = false;
        mInactivityTimer = new InactivityTimer(this);
    }

    private void initDecode() {
        multiFormatReader = new MultiFormatReader();
        // 解码的参数
        Hashtable<DecodeHintType, Object> hints = new Hashtable<>(2);
        // 可以解析的编码类型
        Vector<BarcodeFormat> decodeFormats = new Vector<>();
        Vector<BarcodeFormat> PRODUCT_FORMATS = new Vector<>(5);
        PRODUCT_FORMATS.add(BarcodeFormat.UPC_A);
        PRODUCT_FORMATS.add(BarcodeFormat.UPC_E);
        PRODUCT_FORMATS.add(BarcodeFormat.EAN_13);
        PRODUCT_FORMATS.add(BarcodeFormat.EAN_8);
        // PRODUCT_FORMATS.add(BarcodeFormat.RSS14);
        Vector<BarcodeFormat> ONE_D_FORMATS = new Vector<>(PRODUCT_FORMATS.size() + 4);
        ONE_D_FORMATS.addAll(PRODUCT_FORMATS);
        ONE_D_FORMATS.add(BarcodeFormat.CODE_39);
        ONE_D_FORMATS.add(BarcodeFormat.CODE_93);
        ONE_D_FORMATS.add(BarcodeFormat.CODE_128);
        ONE_D_FORMATS.add(BarcodeFormat.ITF);
        Vector<BarcodeFormat> QR_CODE_FORMATS = new Vector<>(1);
        QR_CODE_FORMATS.add(BarcodeFormat.QR_CODE);
        Vector<BarcodeFormat> DATA_MATRIX_FORMATS = new Vector<>(1);
        DATA_MATRIX_FORMATS.add(BarcodeFormat.DATA_MATRIX);

        // 这里设置可扫描的类型，我这里选择了都支持
        decodeFormats.addAll(ONE_D_FORMATS);
        decodeFormats.addAll(QR_CODE_FORMATS);
        decodeFormats.addAll(DATA_MATRIX_FORMATS);
        hints.put(DecodeHintType.POSSIBLE_FORMATS, decodeFormats);

        multiFormatReader.setHints(hints);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onResume() {
        super.onResume();
        SurfaceView surfaceView = findViewById(R.id.capture_preview);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (mHasSurface) {
            //Camera初始化
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    if (!mHasSurface) {
                        mHasSurface = true;
                        initCamera(holder);
                    }
                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    mHasSurface = false;

                }
            });
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mHandler != null) {
            mHandler.quitSynchronously();
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
        CameraManager.get().closeDriver();
    }

    @Override
    protected void onDestroy() {
        mInactivityTimer.shutdown();
        super.onDestroy();
    }

    private void initView() {
        mIvLight = findViewById(R.id.top_mask);
        mContainer = findViewById(R.id.capture_containter);
        mCropLayout = findViewById(R.id.capture_crop_layout);
        mLlScanHelp = findViewById(R.id.ll_scan_help);


    }

    private void initPermission() {
        //请求Camera权限 与 文件读写 权限
        PermissionUtils.permission(PermissionConstants.CAMERA,PermissionConstants.STORAGE)
                .callback(new SimpleCallback() {
                    @Override
                    public void onGranted() {

                    }

                    @Override
                    public void onDenied() {
                        finish();
                    }
                })
                .request();
    }

    private void initScannerAnimation() {
        ImageView mQrLineView = findViewById(R.id.capture_scan_line);
        ScaleAnimation animation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(1200);
        mQrLineView.startAnimation(animation);
    }

    public int getCropWidth() {
        return mCropWidth;
    }

    public void setCropWidth(int cropWidth) {
        mCropWidth = cropWidth;
        CameraManager.FRAME_WIDTH = mCropWidth;

    }

    public int getCropHeight() {
        return mCropHeight;
    }

    public void setCropHeight(int cropHeight) {
        this.mCropHeight = cropHeight;
        CameraManager.FRAME_HEIGHT = mCropHeight;
    }

    public void btn(View view) {
        int viewId = view.getId();
        if (viewId == R.id.top_mask) {
            light();
        } else if (viewId == R.id.top_back) {
            finish();
        } else if (viewId == R.id.top_openpicture) {//查看本地图片
//            RxPhotoTool.openLocalImage(mContext);
            Intent intent = new Intent(this, ImageGridActivity.class);
            startActivityForResult(intent, IMGPICKER_REQUEST_CODE);
        }
    }

    private void light() {
        if (mFlashing) {
            mFlashing = false;
            // 开闪光灯
            CameraManager.get().openLight();
        } else {
            mFlashing = true;
            // 关闪光灯
            CameraManager.get().offLight();
        }

    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
            Point point = CameraManager.get().getCameraResolution();
            AtomicInteger width = new AtomicInteger(point.y);
            AtomicInteger height = new AtomicInteger(point.x);
            int cropWidth = mCropLayout.getWidth() * width.get() / mContainer.getWidth();
            int cropHeight = mCropLayout.getHeight() * height.get() / mContainer.getHeight();
            setCropWidth(cropWidth);
            setCropHeight(cropHeight);
        } catch (IOException | RuntimeException ioe) {
            return;
        }
        if (mHandler == null) {
            mHandler = new CaptureActivityHandler();
        }
    }


    //--------------------------------------打开本地图片识别二维码 start---------------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS &&requestCode == IMGPICKER_REQUEST_CODE){
            ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
            ImageItem imageItem = images.get(0);
            Bitmap bitmap = ImageUtils.getBitmap(imageItem.path);
            // 开始对图像资源解码
            Result rawResult = RxQrBarTool.decodeFromPhoto(bitmap);
            if (rawResult != null) {
                handleDecode(rawResult);
            } else {
                ToastUtils.showShort("图片识别失败.");
            }
            bitmap.recycle();
        }
    }
    //========================================打开本地图片识别二维码 end=================================


    //扫描成功之后的振动与声音提示
    public void handleDecode(Result result) {
        mInactivityTimer.onActivity();
        String scanResult = result.getText();
        Intent intent = new Intent();
        intent.putExtra(SCAN_RESULT,scanResult);
        setResult(RESULT_CODE,intent);
        finish();
    }
    //==============================================================================================解析结果 及 后续处理 end

    final class CaptureActivityHandler extends Handler {

        DecodeThread decodeThread = null;
        private State state;

        private CaptureActivityHandler() {
            decodeThread = new DecodeThread();
            decodeThread.start();
            state = State.SUCCESS;
            CameraManager.get().startPreview();
            restartPreviewAndDecode();
        }

        @Override
        public void handleMessage(Message message) {
            if (message.what == R.id.auto_focus) {
                if (state == State.PREVIEW) {
                    CameraManager.get().requestAutoFocus(this, R.id.auto_focus);
                }
            } else if (message.what == R.id.restart_preview) {
                restartPreviewAndDecode();
            } else if (message.what == R.id.decode_succeeded) {
                state = State.SUCCESS;
                handleDecode((Result) message.obj);// 解析成功，回调
            } else if (message.what == R.id.decode_failed) {
                state = State.PREVIEW;
                CameraManager.get().requestPreviewFrame(decodeThread.getHandler(), R.id.decode);
            }
        }

        private void quitSynchronously() {
            state = State.DONE;
            decodeThread.interrupt();
            CameraManager.get().stopPreview();
            removeMessages(R.id.decode_succeeded);
            removeMessages(R.id.decode_failed);
            removeMessages(R.id.decode);
            removeMessages(R.id.auto_focus);
        }

        private void restartPreviewAndDecode() {
            if (state == State.SUCCESS) {
                state = State.PREVIEW;
                CameraManager.get().requestPreviewFrame(decodeThread.getHandler(), R.id.decode);
                CameraManager.get().requestAutoFocus(this, R.id.auto_focus);
            }
        }
    }

    final class DecodeThread extends Thread {

        private final CountDownLatch handlerInitLatch;
        private Handler handler;

        DecodeThread() {
            handlerInitLatch = new CountDownLatch(1);
        }

        Handler getHandler() {
            try {
                handlerInitLatch.await();
            } catch (InterruptedException ie) {
                // continue?
            }
            return handler;
        }

        @Override
        public void run() {
            Looper.prepare();
            handler = new DecodeHandler();
            handlerInitLatch.countDown();
            Looper.loop();
        }
    }

    final class DecodeHandler extends Handler {
        DecodeHandler() {
        }

        @Override
        public void handleMessage(Message message) {
            if (message.what == R.id.decode) {
                decode((byte[]) message.obj, message.arg1, message.arg2);
            } else if (message.what == R.id.quit) {
                Looper.myLooper().quit();
            }
        }
    }

    private MultiFormatReader multiFormatReader;

    private void decode(byte[] data, int width, int height) {
        long start = System.currentTimeMillis();
        Result rawResult = null;

        //modify here
        byte[] rotatedData = new byte[data.length];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                rotatedData[x * height + height - y - 1] = data[x + y * width];
            }
        }
        // Here we are swapping, that's the difference to #11
        int tmp = width;
        width = height;
        height = tmp;

        PlanarYUVLuminanceSource source = CameraManager.get().buildLuminanceSource(rotatedData, width, height);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            rawResult = multiFormatReader.decodeWithState(bitmap);
        } catch (ReaderException e) {
            // continue
        } finally {
            multiFormatReader.reset();
        }

        if (rawResult != null) {
//            long end = System.currentTimeMillis();
//            Log.d(TAG, "Found barcode (" + (end - start) + " ms):\n" + rawResult.toString());
            Message message = Message.obtain(mHandler, R.id.decode_succeeded, rawResult);
            Bundle bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", source.renderCroppedGreyscaleBitmap());
            message.setData(bundle);
            //Log.d(TAG, "Sending decode succeeded message...");
            message.sendToTarget();
        } else {
            Message message = Message.obtain(mHandler, R.id.decode_failed);
            message.sendToTarget();
        }
    }

    private enum State {
        //预览
        PREVIEW,
        //成功
        SUCCESS,
        //完成
        DONE
    }
}
