package com.androidxx.yangjw.day38_recyclerview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView是android5.0之后出现的一个新控件
 * 1、导jar包
 * 2、定义一个RecyclerView
 * 3、指定一个布局管理器
 * 4、创建一个数据源
 * 5、创建一个适配器
 * 6、关联适配器
 *
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> datas = new ArrayList<>();
    private List<Integer> images = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //布局管理器，用来决定RecyclerView中的显示效果
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        loadDatas();
        myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
    }

    private void loadDatas() {
        for (int i = 0; i < 20; i++) {
            datas.add("ITEM" + i);
        }

        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a4);
        images.add(R.drawable.abc);
        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a4);
        images.add(R.drawable.abc);
        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a4);
        images.add(R.drawable.abc);
        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a4);
        images.add(R.drawable.abc);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxt;
        public ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt = (TextView) itemView.findViewById(R.id.item_txt);
            mImageView = (ImageView) itemView.findViewById(R.id.item_imageview);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        /**
         * if (view == null) {
         *     创建ViewHold
         * }
         * @param parent
         * @param viewType
         * @return
         */
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_view, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        /**
         * else {
         *     getTag
         * }
         * @param holder onCreateViewHolder此方法传递的
         * @param position
         */
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            String str = datas.get(position);
            holder.mTxt.setText(str);
            holder.mImageView.setImageResource(images.get(position));
        }

        /**
         * 适配器数据源的大小
         * @return
         */
        @Override
        public int getItemCount() {
            return datas == null ? 0 : datas.size();
        }
    }
}
