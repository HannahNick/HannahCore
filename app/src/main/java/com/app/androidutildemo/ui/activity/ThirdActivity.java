package com.app.androidutildemo.ui.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.androidutildemo.R;
import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.widget.TagTextView;
import com.app.hannahcore.factory.view.TextViewFactory;
import com.app.hannahcore.manager.file.FileDownLoadManager;
import com.app.hannahcore.manager.file.FileDownLoadManager.SimpleListener;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.PermissionUtils;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class ThirdActivity extends SimpleBaseActivity {
    private GifImageView mGiv_gif;


    @Override
    protected int contentView() {
        return R.layout.activity_third;
    }

    @Override
    protected void init() {
        TextView textView = findViewById(R.id.tv_title);
        RelativeLayout contain = findViewById(R.id.rl_contain);
        mGiv_gif = findViewById(R.id.giv_gif);

        BarUtils.addMarginTopEqualStatusBarHeight(contain);
        TagTextView view = TextViewFactory.getInstance().createView(TagTextView.class,this);
        view.setContentAndTag("王尼玛大力优惠券","尼玛牌");
        contain.addView(view);
        textView.setOnClickListener(v -> {
            ActivityUtils.startActivity(ForthActivity.class);
        });
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .request();
        FileDownLoadManager
                .getInstance()
                .simpleDownload("https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/beb1e155ad0a4cf61462c2882ee866e5.gif",
                        PathUtils.getExternalDownloadsPath().concat("abc.gif"), new SimpleListener() {
                            @Override
                            public void progress(String percent) {

                            }

                            @Override
                            public void completed(String path) {
                                try {
                                    GifDrawable gifDrawable = new GifDrawable(new File(path));
                                    mGiv_gif.setImageDrawable(gifDrawable);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void error(String msg) {

                            }
                        });
    }


}
