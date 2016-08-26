package com.androidxx.yangjw.day39_mvp_network_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.androidxx.yangjw.day39_mvp_network_demo.adapter.GiftListAdapter;
import com.androidxx.yangjw.day39_mvp_network_demo.bean.GiftBean;
import com.androidxx.yangjw.day39_mvp_network_demo.presenter.GiftPresenterImpl;
import com.androidxx.yangjw.day39_mvp_network_demo.presenter.IGiftPresenter;
import com.androidxx.yangjw.day39_mvp_network_demo.view.IGiftView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IGiftView{

    @BindView(R.id.gift_list)
    ListView mListView;

    private List<GiftBean.ListBean> beanList = new ArrayList<>();
    private GiftListAdapter mGiftListAdapter;
    private IGiftPresenter mGiftPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mGiftPresenter = new GiftPresenterImpl(this);
        setupListView();
        mGiftPresenter.getGiftList(1);
    }

    private void setupListView() {
        mGiftListAdapter = new GiftListAdapter(beanList,this);
        mListView.setAdapter(mGiftListAdapter);
    }

    @Override
    public void refreshListView(List<GiftBean.ListBean> listBeens) {
        beanList.addAll(listBeens);
        mGiftListAdapter.notifyDataSetChanged();
    }
}
