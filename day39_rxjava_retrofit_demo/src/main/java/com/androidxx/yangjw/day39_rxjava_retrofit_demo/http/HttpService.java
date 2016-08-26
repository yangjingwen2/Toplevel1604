package com.androidxx.yangjw.day39_rxjava_retrofit_demo.http;

import com.androidxx.yangjw.day39_rxjava_retrofit_demo.bean.OpenServerBean;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yangjw on 2016/8/26.
 */
public interface HttpService {

    @GET("/majax.action?method=getJtkaifu")
    Observable<OpenServerBean> queryOpenServer();
}
