package com.androidxx.yangjw.day37_retrofit_post_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Post请求
 */
public class MainActivity extends AppCompatActivity implements Callback<GiftBean>{

    private static final String TAG = "androidxx";
//    private HttpService httpService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //创建Retrofit对象
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://www.1688wan.com")
//                .addConverterFactory(GsonConverterFactory.create())//用来将json字符串解析成javabean对象
//                .build();
//        //创建一个HttpService对象
//        httpService = retrofit.create(HttpService.class);
    }

    public void click(View view) {
        HttpUitls.init().queryGiftList(1).enqueue(this);
    }

    @Override
    public void onResponse(Call<GiftBean> call, Response<GiftBean> response) {
        Log.i(TAG, "onResponse: ");
        Toast.makeText(MainActivity.this, "" + response.body().getAd().size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<GiftBean> call, Throwable t) {

    }
}
