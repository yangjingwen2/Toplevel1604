package com.androidxx.yangjw.day36_di_android_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @FindView(R.id.di_textview)
    TextView mTextView;
    @FindView(R.id.di_btn)
    Button mBtn;
    @FindView(R.id.di_imageview)
    ImageView mImageView;
    @FindString(R.string.name)
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Knife.bind(this);

        mTextView.setText("这是通过依赖注入创建的对象");
        mBtn.setText(name);
        mImageView.setImageResource(R.mipmap.ic_launcher);
    }

}
