package com.androidxx.yangjw.day40_videoview_networkdata_demo.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangjw on 2016/8/29.
 */
public class HttpUtils {
    public static final String URL = "https://newapi.meipai.com";
    private static HttpService mHttpService;

    public static HttpService create() {
        if (mHttpService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
//                    .addConverterFactory(GsonConverterFactory.create())//屏蔽此句，表示不需要Gson解析。返回的网络请求结果就是字符串
                    .build();
            mHttpService = retrofit.create(HttpService.class);
        }
        return mHttpService;
    }
}
