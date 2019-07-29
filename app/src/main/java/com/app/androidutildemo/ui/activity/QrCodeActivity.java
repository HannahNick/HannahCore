package com.app.androidutildemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.app.androidutildemo.R;
import com.app.hannahcore.manager.image.GlideManager;
import com.app.hannahcore.service.NetworkService;
import com.app.hannahcore.ui.activity.ScannerCodeActivity;
import com.app.hannahcore.utils.QrcodeUtil;
import com.app.hannahcore.widget.photoview.HannahPhotoView;
import com.app.hannahcore.widget.photoview.Info;
import com.blankj.utilcode.util.ActivityUtils;


public class QrCodeActivity extends AppCompatActivity {

    private Info mCurrentSmallInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        initNetworkService();
        ImageView image = findViewById(R.id.iv_qrcode);
        Button button = findViewById(R.id.btn_scan);
        HannahPhotoView preView = findViewById(R.id.pv_preview);
        ImageView shopImage = findViewById(R.id.iv_image);
        button.setOnClickListener(v -> {
            ActivityUtils.startActivity(ScannerCodeActivity.class);
        });
        GlideManager.getInstance().loadUrl(this,shopImage,"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/9845ac4cfd933d704825c54e6797669d.png");
        GlideManager.getInstance().loadUrl(this,preView,"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/9845ac4cfd933d704825c54e6797669d.png");
        preView.enable();
        shopImage.setOnClickListener(v -> {
            v.setVisibility(View.GONE);
            preView.setVisibility(View.VISIBLE);
            mCurrentSmallInfo= HannahPhotoView.getImageViewInfo(shopImage);
            preView.animaFrom(mCurrentSmallInfo);
        });
        preView.setOnClickListener(v -> {
            preView.animaTo(mCurrentSmallInfo,()->{
                v.setVisibility(View.GONE);
                shopImage.setVisibility(View.VISIBLE);
            });
        });
        QrcodeUtil.createQRCode("https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/9845ac4cfd933d704825c54e6797669d.png",image);
    }

    private void initNetworkService(){
        Intent intent = new Intent(this, NetworkService.class);
        startService(intent);
    }
}
