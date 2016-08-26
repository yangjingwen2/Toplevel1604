package com.androidxx.yangjw.day39_mvp_network_demo.presenter;

import com.androidxx.yangjw.day39_mvp_network_demo.bean.GiftBean;
import com.androidxx.yangjw.day39_mvp_network_demo.model.IGiftModel;
import com.androidxx.yangjw.day39_mvp_network_demo.model.impl.GiftModelImpl;
import com.androidxx.yangjw.day39_mvp_network_demo.view.IGiftView;

/**
 * Created by yangjw on 2016/8/26.
 */
public class GiftPresenterImpl implements IGiftPresenter,IGiftPresenter.Callback {

    IGiftModel mGiftModel;
    IGiftView mGiftView;

    public GiftPresenterImpl(IGiftView giftView) {
        this.mGiftModel = new GiftModelImpl();
        this.mGiftView = giftView;
    }

    @Override
    public void getGiftList(int pageno) {
        mGiftModel.queryGiftList(pageno,this);
    }

    @Override
    public void success(GiftBean giftbean) {
        //通知适配器刷新视图
        if (giftbean != null) {
            mGiftView.refreshListView(giftbean.getList());
        }
    }
}
