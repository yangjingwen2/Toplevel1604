package com.androidxx.yangjw.day36_di_wangbaoqiang_demo;

import java.lang.reflect.Field;

/**
 * Created by yangjw on 2016/8/22.
 */
public class ZhongJie {
    //行为：给马融找一个有钱人，目标王宝强
    public static void find(Marong marong) {
        Class<? extends Marong> aClass = marong.getClass();
        try {
            //获取Marong类中的王宝强这个属性
//            Field wangbaoqiang = aClass.getDeclaredField("wangbaoqiang");
            Field men = aClass.getDeclaredField("men");
            //获取属性men上的注解对象
            //参数：注解类型
            FindMen findMenAnotation = men.getAnnotation(FindMen.class);
            if (findMenAnotation != null) {
                Class aClass1 = findMenAnotation.value();
                //给此属性赋值
                Object newInstance = aClass1.newInstance();
                men.set(marong,newInstance);
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
