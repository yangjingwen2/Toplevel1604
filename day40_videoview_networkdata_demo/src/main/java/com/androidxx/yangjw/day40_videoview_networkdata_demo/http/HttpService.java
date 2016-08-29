package com.androidxx.yangjw.day40_videoview_networkdata_demo.http;


import com.androidxx.yangjw.day40_videoview_networkdata_demo.bean.VideoBean;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yangjw on 2016/8/29.
 */
public interface HttpService {

//    @GET("/channels/feed_timeline.json")
//    Call<List<VideoBean>> queryVideoList(@Query("id") int id);

    @GET("/channels/feed_timeline.json")
    Call<ResponseBody> queryVideoList(@Query("id") int id);
}
