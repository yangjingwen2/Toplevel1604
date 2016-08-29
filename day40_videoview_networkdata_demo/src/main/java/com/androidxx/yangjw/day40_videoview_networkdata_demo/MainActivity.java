package com.androidxx.yangjw.day40_videoview_networkdata_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidxx.yangjw.day40_videoview_networkdata_demo.bean.VideoBean;
import com.androidxx.yangjw.day40_videoview_networkdata_demo.http.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTexImage2D;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    private RecyclerView mRecyclerView;
    private List<VideoBean> videoBeanList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadDatas();
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
    }

    private void loadDatas() {
        HttpUtils.create().queryVideoList(1).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
//                    Log.i(TAG, "onResponse: " + );
                    String result = response.body().string();
                    Gson gson = new Gson();
                    Type type =  new TypeToken<List<VideoBean>>(){}.getType();
                    List<VideoBean> videoList = gson.fromJson(result, type);
                    videoBeanList.addAll(videoList);
                    myAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public GifImageView mImageView;
        public TextView mTitleTxt;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (GifImageView) itemView.findViewById(R.id.item_iv);
            mTitleTxt = (TextView) itemView.findViewById(R.id.item_txt);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_view, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            VideoBean videoBean = videoBeanList.get(position);
            holder.mTitleTxt.setText(videoBean.getRecommend_caption());
            Picasso.with(MainActivity.this).load(videoBean.getRecommend_cover_pic()).into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return videoBeanList == null?0:videoBeanList.size();
        }
    }
}
