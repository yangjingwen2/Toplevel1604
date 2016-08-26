package com.androidxx.yangjw.day39_mvp_network_demo.http;

import com.androidxx.yangjw.day39_mvp_network_demo.bean.GiftBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yangjw on 2016/8/26.
 */
public interface HttpService {

    //http://www.1688wan.com/majax.action?method=getGiftList
    @Deprecated
    @POST("/majax.action?method=getGiftList")
    Call<GiftBean> queryGift(@Query("pageno") int num);

    @POST("/majax.action?method=getGiftList")
    Observable<GiftBean> queryGift2(@Query("pageno") int num);
}
