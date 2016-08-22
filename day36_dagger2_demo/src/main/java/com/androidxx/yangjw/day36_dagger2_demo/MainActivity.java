package com.androidxx.yangjw.day36_dagger2_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    @Inject
    UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //----
        UserComponent userComponent = DaggerUserComponent.create();
        userComponent.bind(this);

        String username = userBean.getUsername();
        Log.i(TAG, "onCreate: " + username);
    }
}
