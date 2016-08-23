package com.androidxx.yangjw.day37_retrofit_post_demo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangjw on 2016/8/23.
 */
public class HttpUitls {

    private static HttpService mHttpService;
    public static final String BASE_URL = "http://www.1688wan.com";

    public static HttpService init() {
        if (mHttpService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mHttpService = retrofit.create(HttpService.class);
        }

        return mHttpService;
    }
}
