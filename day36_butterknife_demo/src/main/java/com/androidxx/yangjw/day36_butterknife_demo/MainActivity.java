package com.androidxx.yangjw.day36_butterknife_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.knife_txt)
    TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTxt.setText("ssssssssssss");
    }

    @OnClick(R.id.knife_btn)
    public void click(View view) {
        Toast.makeText(MainActivity.this, "sss", Toast.LENGTH_SHORT).show();
    }
}
