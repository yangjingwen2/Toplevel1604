package com.androidxx.yangjw.day39_mvp_demo.model;

/**
 * Created by yangjw on 2016/8/26.
 */
public class CustomModel implements IUserModel{

    private String getLiName() {
        return "lisi";
    }

    @Override
    public String getName() {
        return getLiName();
    }
}
