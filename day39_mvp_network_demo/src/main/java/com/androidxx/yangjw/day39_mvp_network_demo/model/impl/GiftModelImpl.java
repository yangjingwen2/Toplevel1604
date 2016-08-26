package com.androidxx.yangjw.day39_mvp_network_demo.model.impl;

import com.androidxx.yangjw.day39_mvp_network_demo.bean.GiftBean;
import com.androidxx.yangjw.day39_mvp_network_demo.http.HttpUtils;
import com.androidxx.yangjw.day39_mvp_network_demo.model.IGiftModel;
import com.androidxx.yangjw.day39_mvp_network_demo.presenter.IGiftPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by yangjw on 2016/8/26.
 */
public class GiftModelImpl implements IGiftModel {


    @Override
    public void queryGiftList(int pageno,final IGiftPresenter.Callback callback) {
//        HttpUtils.create().queryGift(pageno).enqueue(new Callback<GiftBean>() {
//            @Override
//            public void onResponse(Call<GiftBean> call, Response<GiftBean> response) {
//                callback.success(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<GiftBean> call, Throwable t) {
//
//            }
//        });
        HttpUtils.create().queryGift2(pageno)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GiftBean>() {
                    @Override
                    public void call(GiftBean giftBean) {
                        callback.success(giftBean);
                    }
                });

    }
}
