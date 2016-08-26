package com.androidxx.yangjw.day39_rxjava_retrofit_demo.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangjw on 2016/8/26.
 */
public class HttpUtils {

    public static final String BASE_URL = "http://www.1688wan.com";

    private static HttpService mHttpService;
    public static HttpService create() {
        if (mHttpService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//结合RxJava
                    .build();
            mHttpService = retrofit.create(HttpService.class);
        }

        return mHttpService;
    }
}
