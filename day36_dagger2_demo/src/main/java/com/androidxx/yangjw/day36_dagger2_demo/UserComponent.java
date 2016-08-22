package com.androidxx.yangjw.day36_dagger2_demo;

import dagger.Component;

/**
 * Created by yangjw on 2016/8/22.
 * 中介:Component表示当前类就是一个中介角色
 */
@Component
public interface UserComponent {
    void bind(MainActivity activity);
}
