package com.androidxx.yangjw.day38_greendao_curd_demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

//    private ArticleDao articleDao;
    private List<Article> articlesList = new ArrayList<>();
    private ListView mListView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AndroidxxDaoMaster.DevOpenHelper devOpenHelper = new AndroidxxDaoMaster.DevOpenHelper(this, "androidxx");
//        SQLiteDatabase readableDatabase = devOpenHelper.getReadableDatabase();
//        AndroidxxDaoMaster androidxxDaoMaster = new AndroidxxDaoMaster(readableDatabase);
//        AndroidxxDaoSession androidxxDaoSession = androidxxDaoMaster.newSession();
//        articleDao = androidxxDaoSession.getArticleDao();
        initView();
        loadDatas();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.greendao_list);
        myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               final  Article article = articlesList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("警告");
                builder.setMessage("温馨提示：您确实不是因为手贱点击的删除？");
                builder.setNegativeButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBUtils.getDao(MainActivity.this).deleteByKey(article.getId());
                        loadDatas();
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    private void loadDatas() {
        articlesList.clear();
        List<Article> articles = DBUtils.getDao(this).loadAll();
        articlesList.addAll(articles);
        myAdapter.notifyDataSetChanged();
    }

    public void click(View view) {
        //跳转到新增的界面
        Intent intent = new Intent(this,AddActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            loadDatas();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,AddActivity.class);
        Article article = articlesList.get(position);
        intent.putExtra("id",article.getId());
        startActivityForResult(intent,2);
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return articlesList == null ? 0 : articlesList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) convertView;
            if (view == null) {
                view = new TextView(MainActivity.this);
            }
            Article article = articlesList.get(position);
            view.setText(article.getTitle() + ":" + article.getContent());
            return view;
        }
    }
}
