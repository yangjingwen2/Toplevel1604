package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

import android.util.Log;

/**
 * Created by yangjw on 2016/8/22.
 */
public class SongJiji implements Men{

    private static final String TAG = "androidxx";
    public int money=200;

    public int costSongMoney(int money) {
        Log.i(TAG, "costSongMoney: 宋喆的钱");
        return this.money >= money ? money : this.money;
    }

    @Override
    public float costMoney(int money) {
        return costSongMoney(money);
    }
}
