package com.app.androidutildemo.ui.activity;

import android.widget.TextView;

import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.R;
import com.blankj.utilcode.util.ActivityUtils;

public class ForthActivity extends SimpleBaseActivity {

    @Override
    protected int contentView() {
        return R.layout.activity_forth;
    }

    @Override
    protected void init() {
        TextView textView = findViewById(R.id.tv_title);
        textView.setOnClickListener(v -> {
//            ActivityUtils.finishToActivity(this,true,true);
            ActivityUtils.finishToActivity(SecondActivity.class,false,false);
//            ActivityUtils.finishActivity(ThirdActivity.class);
        });
    }


}
