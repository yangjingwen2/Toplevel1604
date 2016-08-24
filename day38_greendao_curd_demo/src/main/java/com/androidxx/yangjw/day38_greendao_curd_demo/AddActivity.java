package com.androidxx.yangjw.day38_greendao_curd_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private EditText mTitleEdt;
    private EditText mContentEdt;
    private long id;
    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        id = getIntent().getLongExtra("id",0);
        if (id > 0) {
            article = DBUtils.getDao(this).load(id);
            mTitleEdt.setText(article.getTitle());
            mContentEdt.setText(article.getContent());
        } else {
            article = new Article();
        }
    }

    private void initView() {
        mTitleEdt = (EditText) findViewById(R.id.add_title_edt);
        mContentEdt = (EditText) findViewById(R.id.add_content_edt);
    }

    public void click(View view) {

        String title = mTitleEdt.getText().toString();
        String content = mContentEdt.getText().toString();
        if ("".equals(title)) {
            Toast.makeText(AddActivity.this, "标题不能为空", Toast.LENGTH_SHORT).show();
            return ;
        }
        //新增到数据库

//        if (id > 0) {
            article.setTitle(title);
            article.setContent(content);
//            DBUtils.getDao(this).update(article);
//        } else {
//            Article article = new Article();
//            article.setTitle(title);
//            article.setContent(content);
//            DBUtils.getDao(this).insert(article);
//
//        }
        DBUtils.getDao(this).insertOrReplace(article);
        setResult(RESULT_OK);
        finish();
    }
}
