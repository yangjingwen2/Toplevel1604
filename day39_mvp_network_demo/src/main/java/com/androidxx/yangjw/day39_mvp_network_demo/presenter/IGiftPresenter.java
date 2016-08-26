package com.androidxx.yangjw.day39_mvp_network_demo.presenter;

import com.androidxx.yangjw.day39_mvp_network_demo.bean.GiftBean;

/**
 * Created by yangjw on 2016/8/26.
 */
public interface IGiftPresenter {

    /**
     * 查询礼包列表
     * @param pageno
     * @author javen
     * 2016.8.28
     */
    void getGiftList(int pageno);

    /**
     * 接口回调：用于接收网络请求之后的数据
     */
    interface Callback {
        void success(GiftBean giftbean);
    }
}
