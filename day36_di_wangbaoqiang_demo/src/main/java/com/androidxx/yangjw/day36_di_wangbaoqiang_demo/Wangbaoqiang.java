package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

import android.util.Log;

/**
 * Created by yangjw on 2016/8/22.
 */
public class Wangbaoqiang implements Men{
    private static final String TAG = "androidxx";
    /**
     * 王宝强的现有存款
     */
    private float money = 1000;

    /**
     * 花钱
     * @param money 需要花多少钱
     */
    public float castMoney(int money) {
        Log.i(TAG, "castMoney: 王宝强的钱");
        if (this.money >= money) {
            return money;
        }
        return this.money;
    }

    @Override
    public float costMoney(int money) {
        return castMoney(money);
    }
}
