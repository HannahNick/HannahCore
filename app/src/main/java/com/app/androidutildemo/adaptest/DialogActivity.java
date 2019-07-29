package com.app.androidutildemo.adaptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.app.androidutildemo.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button button = findViewById(R.id.btn_show_dialog);
        button.setOnClickListener(v -> {

        });


    }
}
