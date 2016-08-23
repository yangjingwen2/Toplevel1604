package com.androidxx.yangjw.day37_retrofit_post_demo;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yangjw on 2016/8/23.
 */
public interface HttpService {
    /**
     * POST注解标注当前的请求为Post请求
     * @return
     */
    @POST("/majax.action?method=getGiftList")
    Call<GiftBean> queryGiftList(@Query("pageno")int pageno);
}
