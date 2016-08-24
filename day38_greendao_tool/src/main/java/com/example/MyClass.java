package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {

    public static void main(String[] args) {
        curdDemo();

    }

    private static void curdDemo() {
        Schema schema = new Schema("androidxx",1,"com.androidxx.yangjw.day38_greendao_curd_demo");
        //添加表
        Entity entity = schema.addEntity("Article");
        entity.addIdProperty().autoincrement();
        entity.addStringProperty("title").notNull();
        entity.addStringProperty("content");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"../TopLevel1604/day38_greendao_curd_demo/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void test() {
        //创建表和数据库
        /**
         * schema模板
         * 参数1：数据库的版本号
         * 参数2：自动生成的Java类存放的包名
         */
        Schema schema = new Schema(1,"com.androidxx.yangjw.day38_greendao_demo.dao");
        //创建表
        Entity tb_user = schema.addEntity("tb_user");
        //给表添加字段
        tb_user.addIdProperty().autoincrement();
        tb_user.addStringProperty("name").notNull();
        tb_user.addIntProperty("age");
        //自动生成数据库文件和Java Bean文件
        /**
         * 参数1：Schema模板
         * 参数2：自动生成的文件存放的路径
         */
        try {
            new DaoGenerator().generateAll(schema,"../TopLevel1604/day38_greendao_demo/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
