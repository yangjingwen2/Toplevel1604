package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Marong marong = new Marong();
        ZhongJie.find(marong);
        boolean success = marong.buyLV(200);
        Toast.makeText(MainActivity.this, "购买结果：" + success, Toast.LENGTH_SHORT).show();
    }
}
