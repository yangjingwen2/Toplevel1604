package com.androidxx.yangjw.day38_greendao_curd_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by yangjw on 2016/8/24.
 */
public class DBUtils {

    private static ArticleDao articleDao;

    public static ArticleDao getDao(Context context) {
        if (articleDao == null) {
            AndroidxxDaoMaster.DevOpenHelper devOpenHelper = new AndroidxxDaoMaster.DevOpenHelper(context, "androidxx");
            SQLiteDatabase readableDatabase = devOpenHelper.getReadableDatabase();
            AndroidxxDaoMaster androidxxDaoMaster = new AndroidxxDaoMaster(readableDatabase);
            AndroidxxDaoSession androidxxDaoSession = androidxxDaoMaster.newSession();
            articleDao = androidxxDaoSession.getArticleDao();
        }

        return articleDao;
    }
}
