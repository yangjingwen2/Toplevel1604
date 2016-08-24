package com.androidxx.yangjw.day38_greendao_demo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidxx.yangjw.day38_greendao_demo.dao.DaoMaster;
import com.androidxx.yangjw.day38_greendao_demo.dao.DaoSession;
import com.androidxx.yangjw.day38_greendao_demo.dao.tb_user;
import com.androidxx.yangjw.day38_greendao_demo.dao.tb_userDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    tb_userDao tb_userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化UserDao文件
        /**
         * 参数1：上下文
         * 参数2：数据库的名称
         */
        DaoMaster.OpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "androidxx");
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(readableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        tb_userDao = daoSession.getTb_userDao();
        tb_user user = new tb_user();
        user.setName("lisi");
        user.setAge(34);
        //新增数据
        tb_userDao.insert(user);
    }

    public void click(View view) {
        List<tb_user> tb_users = tb_userDao.loadAll();
        for (int i = 0; i < tb_users.size(); i++) {
            tb_user tb_user = tb_users.get(i);
            Log.i(TAG, "click: " + tb_user.getName());
        }
    }


}
