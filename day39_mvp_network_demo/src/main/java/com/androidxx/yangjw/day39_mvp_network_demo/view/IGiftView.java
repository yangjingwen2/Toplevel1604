package com.androidxx.yangjw.day39_mvp_network_demo.view;

import com.androidxx.yangjw.day39_mvp_network_demo.bean.GiftBean;

import java.util.List;

/**
 * Created by yangjw on 2016/8/26.
 */
public interface IGiftView {

    /**
     * 刷新适配器更新视图
     * @param listBeens 礼包列表数据
     */
    void refreshListView(List<GiftBean.ListBean> listBeens);
}
