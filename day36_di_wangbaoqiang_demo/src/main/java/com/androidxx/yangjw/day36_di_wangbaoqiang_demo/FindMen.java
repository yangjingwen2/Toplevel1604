package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yangjw on 2016/8/22.
 * 元注解
 * Target:表示著名自定义的注解的作用对象,ElementType.FIELD表示当前注解作用于属性
 * Retention:表示当前自定义的注解在哪一个时段内有效。RetentionPolicy.RUNTIME表示注册作用于程序运行期间
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindMen {
    Class value();//表示Men的取值内容。Class表示当前value的取值类型
}
