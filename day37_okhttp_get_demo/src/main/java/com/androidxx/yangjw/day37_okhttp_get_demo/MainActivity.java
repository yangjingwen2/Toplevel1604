package com.androidxx.yangjw.day37_okhttp_get_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp的Get请求
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    /**
     * 官方建议：一个APP中最好只有一个OkHttpClient对象
     */
    private OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
       final Request request = new Request.Builder()
                .url("http://192.168.59.173:8080/WebServer/androidxx.do?name=lisi")
                .get()
                .build();

       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   /**
                    * request：里面包含有需要传递给服务器的数据
                    * execute方法是同步请求
                    * 返回内容：
                    * response中包含了请求到的结果
                    */
                   Response response = okHttpClient.newCall(request).execute();
                   //response.body().string()执行执行一次
                   String result = response.body().string();
                   Log.i(TAG, "run: " + result);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }
}
