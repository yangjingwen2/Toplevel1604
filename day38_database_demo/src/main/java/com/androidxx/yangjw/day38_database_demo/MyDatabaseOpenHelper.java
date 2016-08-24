package com.androidxx.yangjw.day38_database_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yangjw on 2016/8/24.
 */
public class MyDatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String TB_USER_NAME = "tb_user";
    public static final String TB_USER_COLUMN_NAME = "name";
    public static final String TB_USER_COLUMN_AGE = "age";
    public static final String TB_UESR = "create table "+TB_USER_NAME+" (_id INTEGER primary key autoincrement,"+TB_USER_COLUMN_NAME+" text,"+TB_USER_COLUMN_AGE+" int)";
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "androidxx";

    public MyDatabaseOpenHelper(Context context) {
        this(context,DB_NAME,null,DB_VERSION);
    }

    /**
     *
     * @param context
     * @param name 数据库的名称
     * @param factory
     * @param version 数据库的版本
     */
    public MyDatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 数据库第一次使用的时候执行
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TB_UESR);
    }

    /**
     * 对数据库更新
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
