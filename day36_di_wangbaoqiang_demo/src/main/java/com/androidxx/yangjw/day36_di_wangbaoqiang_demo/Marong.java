package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

/**
 * Created by yangjw on 2016/8/22.
 */
public class Marong {

    //获得王宝强
    //   Wangbaoqiang wangbaoqiang = new Wangbaoqiang();
    @FindMen(Wangxiaomin.class)
    Men men;


    public boolean buyLV(int value) {
        //花王宝强的钱
        float castMoney = men.costMoney(200);
        if (castMoney >= value) {
            return true;
        }
        return false;
    }
}
