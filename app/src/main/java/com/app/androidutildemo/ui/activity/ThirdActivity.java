package com.app.androidutildemo.ui.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.androidutildemo.R;
import com.app.androidutildemo.SimpleBaseActivity;
import com.app.hannahcore.factory.view.TextViewFactory;
import com.app.androidutildemo.widget.TagTextView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;

public class ThirdActivity extends SimpleBaseActivity {

    @Override
    protected int contentView() {
        return R.layout.activity_third;
    }

    @Override
    protected void init() {
        TextView textView = findViewById(R.id.tv_title);
        RelativeLayout contain = findViewById(R.id.rl_contain);
        BarUtils.addMarginTopEqualStatusBarHeight(contain);
        TagTextView view = TextViewFactory.getInstance().createView(TagTextView.class,this);
        view.setContentAndTag("王尼玛大力优惠券","尼玛牌");
        contain.addView(view);
        textView.setOnClickListener(v -> {
            ActivityUtils.startActivity(ForthActivity.class);
        });
    }


}
