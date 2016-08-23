package com.androidxx.yangjw.day37_retrofit_get_demo;

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
 * 使用步骤：
 * 1、导包
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    private HttpService httpService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.1688wan.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpService = retrofit.create(HttpService.class);
    }

    public void click(View view) {

        kaifu();
        kaice();
    }

    private void kaice() {
        httpService.getKaifu("getWebfutureTest").enqueue(new Callback<KaifuBean>() {
            @Override
            public void onResponse(Call<KaifuBean> call, Response<KaifuBean> response) {
                Toast.makeText(MainActivity.this, "开测："+response.body().getInfo().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<KaifuBean> call, Throwable t) {

            }
        });
    }

    private void kaifu() {
        Call<KaifuBean> jtKaifu = httpService.getKaifu("getJtkaifu");
        jtKaifu.enqueue(new Callback<KaifuBean>() {
            /**
             * 运行在主线程上
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<KaifuBean> call, Response<KaifuBean> response) {
                KaifuBean body = response.body();
                Log.i(TAG, "onResponse: " + body.getInfo().get(0).getId());
                Toast.makeText(MainActivity.this, "开服：" + body.getInfo().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<KaifuBean> call, Throwable t) {

            }
        });
    }
}
