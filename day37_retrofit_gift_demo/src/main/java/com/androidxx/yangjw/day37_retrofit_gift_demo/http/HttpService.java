package com.androidxx.yangjw.day37_retrofit_gift_demo.http;

import com.androidxx.yangjw.day37_retrofit_gift_demo.bean.OpenServiceBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yangjw on 2016/8/23.
 */
public interface HttpService {

    @GET("/majax.action?method=getJtkaifu")
    Call<OpenServiceBean> queryOpenServer();
}

