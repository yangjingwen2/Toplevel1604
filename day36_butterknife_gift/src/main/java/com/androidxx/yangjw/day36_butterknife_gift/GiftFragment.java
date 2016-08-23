package com.androidxx.yangjw.day36_butterknife_gift;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangjw on 2016/8/22.
 */
public class GiftFragment extends BaseFragment{

    private Context mContext;
    @BindView(R.id.gift_list_lv)
    ListView mListView;

    private List<String> datas = new ArrayList<>();
    private MyAdapter myAdapter;

    public static GiftFragment newInstance() {
        GiftFragment giftFragment = new GiftFragment();
        return giftFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_list_view, container, false);
        ButterKnife.bind(this,view);
        initHeaderView();
        loadDatas();
        myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);
        return view;
    }

    private void initHeaderView() {
        View headerView = LayoutInflater.from(mContext).inflate(R.layout.gift_list_header_view, null);
        HeaderViewHolder headerViewHolder = new HeaderViewHolder(headerView);
        headerViewHolder.mHeaderTxt.setText("这是头部");

        mListView.addHeaderView(headerView);
    }

    class HeaderViewHolder {
        @BindView(R.id.gift_list_header_text)
        public TextView mHeaderTxt;
        public HeaderViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }

    private void loadDatas() {
        for (int i = 0; i < 20; i++) {
            datas.add("ITEM" + i);
        }
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datas == null ? 0 : datas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder viewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.gift_list_item_view,parent,false);
                viewHolder = new ViewHolder(view);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.mTxt.setText(datas.get(position));
            return view;
        }

        class ViewHolder {
            @BindView(R.id.gift_list_item_txt)
            TextView mTxt;

            public ViewHolder(View view) {
                view.setTag(this);
                ButterKnife.bind(this,view);
            }
        }
    }

}
