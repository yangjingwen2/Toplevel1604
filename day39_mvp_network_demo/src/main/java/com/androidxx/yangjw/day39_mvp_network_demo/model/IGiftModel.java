package com.androidxx.yangjw.day39_mvp_network_demo.model;

import com.androidxx.yangjw.day39_mvp_network_demo.presenter.IGiftPresenter;

/**
 * Created by yangjw on 2016/8/26.
 */
public interface IGiftModel {

    /**
     * 查询礼包列表
     * @param pageno
     * @author javen
     * 2016.8.28
     */
    void queryGiftList(int pageno, IGiftPresenter.Callback callback);
}
