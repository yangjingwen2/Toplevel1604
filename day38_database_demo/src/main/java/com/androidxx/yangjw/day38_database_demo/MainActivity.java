package com.androidxx.yangjw.day38_database_demo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 回顾Database：SQLiteDatabase
 * 1、创建一个类继承DatabaseOpenHelper
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    private MyDatabaseOpenHelper myDatabaseOpenHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取数据库
        myDatabaseOpenHelper = new MyDatabaseOpenHelper(this);
        db = myDatabaseOpenHelper.getReadableDatabase();
        //添加数据
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseOpenHelper.TB_USER_COLUMN_NAME,"zhangsan");
        contentValues.put(MyDatabaseOpenHelper.TB_USER_COLUMN_AGE,23);
        db.insert(MyDatabaseOpenHelper.TB_USER_NAME,null,contentValues);
    }

    /**
     * 查询数据库
     * @param view
     */
    public void click(View view) {
        Cursor cursor = db.query(MyDatabaseOpenHelper.TB_USER_NAME, null, null, null, null, null, null);
//        cursor.moveToFirst();
        while(cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(MyDatabaseOpenHelper.TB_USER_COLUMN_NAME));
            Log.i(TAG, "click: " + name);
        }
    }
}
