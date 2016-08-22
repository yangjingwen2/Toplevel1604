package com.androidxx.yangjw.day36_di_android_demo;

import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by yangjw on 2016/8/22.
 */
public class Knife {

    public static void bind(MainActivity activity) {
        try {
            Class<? extends MainActivity> aClass = activity.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                FindView findView = declaredFields[i].getAnnotation(FindView.class);
                if (findView != null) {
                    int ids = findView.value();
                    View view = activity.findViewById(ids);
                    /**
                     * 参数1：表示当前属性是哪一个对象的，对象名称
                     * 参数2：属性的值
                     */
                    declaredFields[i].set(activity,view);
                }
                FindString findString = declaredFields[i].getAnnotation(FindString.class);
                if (findString != null) {
                    int resIds = findString.value();
                    String string = activity.getResources().getString(resIds);
                    String replace = string.replace("喆", "*");
                    declaredFields[i].set(activity,"[androidxx：]"+replace);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
