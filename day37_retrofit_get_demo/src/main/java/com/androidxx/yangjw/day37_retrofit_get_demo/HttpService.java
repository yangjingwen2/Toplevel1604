package com.androidxx.yangjw.day37_retrofit_get_demo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yangjw on 2016/8/23.
 */
public interface HttpService {

    //http://www.1688wan.com/majax.action?method=getJtkaifu
//    @GET("/majax.action?method=getJtkaifu")
//    Call<KaifuBean> getJtKaifu();
//
//    @GET("/majax.action?method=getWebfutureTest")
//    Call<KaiceBean> getKaice();


    /**
     * @GET：表示本次请求为Get请求。
     * @Query：请求的参数
     * @param method
     * @return
     */
    @GET("/majax.action")
    Call<KaifuBean> getKaifu(@Query("method")String method);

}
