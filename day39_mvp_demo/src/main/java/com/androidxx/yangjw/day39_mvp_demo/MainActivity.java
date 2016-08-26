package com.androidxx.yangjw.day39_mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androidxx.yangjw.day39_mvp_demo.presenter.IUserPresenter;
import com.androidxx.yangjw.day39_mvp_demo.presenter.UserPresenter;
import com.androidxx.yangjw.day39_mvp_demo.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView{

    private TextView mShowText;
    private IUserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserPresenter = new UserPresenter(this);
        mShowText = (TextView) findViewById(R.id.mvp_show_txt);
    }

    public void click(View view) {
        mUserPresenter.getName();
    }


    @Override
    public void setText(String name) {
        mShowText.setText(name);
    }
}
