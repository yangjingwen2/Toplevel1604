package com.androidxx.yangjw.day38_recyclerview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Integer> datas = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadDatas();
        myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
    }

    private void loadDatas() {
        for (int i = 0; i < 4; i++) {
            datas.add(R.drawable.a1);
            datas.add(R.drawable.a2);
            datas.add(R.drawable.a3);
            datas.add(R.drawable.a4);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView mTxt;
        public View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.card_item_iv);
            mTxt = (TextView) itemView.findViewById(R.id.card_item_txt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int tag = Integer.parseInt(v.getTag().toString());
            Toast.makeText(RecyclerViewActivity.this, "" + tag, Toast.LENGTH_SHORT).show();
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        /**
         *
         * @param position 索引
         * @return
         */
        @Override
        public int getItemViewType(int position) {
            return position;
        }

        /**
         *
         * @param parent
         * @param viewType 是getItemViewType方法返回的值
         * @return
         */
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = null;
            if(viewType == 0) {
                view = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.header_view,parent,false);
            } else {
                view = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.card_item_view, parent, false);
            }
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (position>0) {
                holder.mImageView.setImageResource(datas.get(position));
                holder.mTxt.setText("ITEM" + position);
                holder.view.setTag(position);
            }

        }

        @Override
        public int getItemCount() {
            return datas == null?0:datas.size();
        }
    }
}
