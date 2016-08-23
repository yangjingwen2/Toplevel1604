package com.androidxx.yangjw.day37_retrofit_gift_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.androidxx.yangjw.day37_retrofit_gift_demo.R;
import com.androidxx.yangjw.day37_retrofit_gift_demo.bean.OpenServiceBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangjw on 2016/8/23.
 */
public class MyExpandAdapter extends BaseExpandableListAdapter {

    private Map<String,ArrayList<OpenServiceBean.InfoBean>> datas;
    private List<String> keyList ;
    private Context mContext;

    public MyExpandAdapter(Map<String, ArrayList<OpenServiceBean.InfoBean>> datas,Context context,List<String> keys) {
        this.datas = datas;
        this.mContext = context;
        this.keyList = keys;
    }

    @Override
    public int getGroupCount() {
        return keyList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String key = keyList.get(groupPosition);
        ArrayList<OpenServiceBean.InfoBean> beanArrayList = datas.get(key);
        return beanArrayList == null ? 0 : beanArrayList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        GroupViewHolder groupViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.group_item_view, parent, false);
            groupViewHolder = new GroupViewHolder(view);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        String key = keyList.get(groupPosition);
        groupViewHolder.mTitleTxt.setText(key);
        return view;
    }

    class GroupViewHolder {

        @BindView(R.id.gift_group_item_title)
        public TextView mTitleTxt;

        public GroupViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if (textView == null) {
            textView = new TextView(mContext);
        }
        String key = keyList.get(groupPosition);
        ArrayList<OpenServiceBean.InfoBean> infoBeanArrayList = datas.get(key);
        OpenServiceBean.InfoBean infoBean = infoBeanArrayList.get(childPosition);
        textView.setText(infoBean.getGname()+"///" + infoBean.getAddtime());
        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
