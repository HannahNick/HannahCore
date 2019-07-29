package com.app.androidutildemo.ui.activity;

import android.widget.TextView;

import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.R;
import com.blankj.utilcode.util.ActivityUtils;

public class ThirdActivity extends SimpleBaseActivity {

    @Override
    protected int contentView() {
        return R.layout.activity_third;
    }

    @Override
    protected void init() {
        TextView textView = findViewById(R.id.tv_title);
        textView.setOnClickListener(v -> {
            ActivityUtils.startActivity(ForthActivity.class);
        });
    }


}
