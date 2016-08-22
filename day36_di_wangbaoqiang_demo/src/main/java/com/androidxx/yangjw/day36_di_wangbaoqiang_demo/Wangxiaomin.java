package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

import android.util.Log;

/**
 * Created by yangjw on 2016/8/22.
 */
public class Wangxiaomin implements Men{

    private static final String TAG = "androidxx";

    @Override
    public float costMoney(int money) {
        Log.i(TAG, "costMoney: 王小明");
        return 200;
    }
}
