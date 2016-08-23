package com.androidxx.yangjw.day37_okhttp_post_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * OkHttp的Post请求
 */
public class MainActivity extends AppCompatActivity {


    private static final String TAG = "androidxx";
    private OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view) {
        requestBody();
    }

    public void click2(View view) {
        formBody();
    }

    /**
     * Json格式的数据
     */
    private void requestBody() {
        /**
         * 参数一：传递的数据格式
         * 参数二：需要传递的数据
         *
         */
        String json = "{'name':'zhangsan'}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url("http://192.168.59.173:8080/WebServer/androidxx.action")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onResponse: " + response.body().string());

                //官方建议：当不需要再次使用response的时候，需要对其进行关闭
                response.close();
            }
        });
    }

    /**
     * 表单格式的数据传递：Form表单类型的数据
     */
    private void formBody() {
        FormBody formBody = new FormBody.Builder()
                .add("name","{name:zhaoliu}")
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.59.173:8080/WebServer/androidxx.action")
                .post(formBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            /**
             * 此方法执行在子线程中
             * @param call
             * @param response
             * @throws IOException
             */
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onResponse: " + response.body().string());
            }
        });
    }
}
