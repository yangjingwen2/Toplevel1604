package com.androidxx.yangjw.day36_dagger2_demo;

import javax.inject.Inject;

/**
 * Created by yangjw on 2016/8/22.
 */
public class UserBean {

    private String name;
    @Inject
    public UserBean() {
    }

    public UserBean(String name) {
        this.name = name;
    }

    public String getUsername() {
        return "zhangsan";
    }
}
