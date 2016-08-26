package com.androidxx.yangjw.day39_rxjava_retrofit_demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.androidxx.yangjw.day39_rxjava_retrofit_demo.bean.OpenServerBean;
import com.androidxx.yangjw.day39_rxjava_retrofit_demo.http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "androidxx";
    private Map<String,List<OpenServerBean.InfoBean>> map = new HashMap<>();
    private List<String> keyList = new ArrayList<>();

//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            //更新UI
//            myAdapter.notifyDataSetChanged();
//        }
//    };
    private ExpandableListView mExpandListView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandListView = (ExpandableListView) findViewById(R.id.list_view);
        myAdapter = new MyAdapter();
        mExpandListView.setAdapter(myAdapter);
        rxjava();
//        HttpUtils.create().queryOpenServer().enqueue(new Callback<OpenServerBean>() {
//            @Override
//            public void onResponse(Call<OpenServerBean> call, Response<OpenServerBean> response) {
//                final OpenServerBean body = response.body();
//                //运行在主线中
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        formatResult(body);
//                        mHandler.sendEmptyMessage(1);
//                    }
//                }).start();
//
//            }
//
//            @Override
//            public void onFailure(Call<OpenServerBean> call, Throwable t) {
//
//            }
//        });
    }

    private void rxjava() {
        HttpUtils.create().queryOpenServer()
                .map(new Func1<OpenServerBean, Map<String,List<OpenServerBean.InfoBean>>>() {
                    @Override
                    public Map<String,List<OpenServerBean.InfoBean>> call(OpenServerBean openServerBean) {
                        Log.i(TAG, "11call: " + Thread.currentThread().getName());
                        return formatResult(openServerBean);
                    }
                })
//                .flatMap()//遍历集合相关的数据时，回调方法
//                .filter()//过滤
                .observeOn(AndroidSchedulers.mainThread())//AndroidSchedulers是RxAndroid中的一个类
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<Map<String, List<OpenServerBean.InfoBean>>>() {
                    @Override
                    public void call(Map<String, List<OpenServerBean.InfoBean>> stringListMap) {
                        Log.i(TAG, "22call: " + Thread.currentThread().getName());
                        map.putAll(stringListMap);
                        myAdapter.notifyDataSetChanged();
                    }
                });
    }

    private Map<String,List<OpenServerBean.InfoBean>> formatResult(OpenServerBean bean) {
        Map<String,List<OpenServerBean.InfoBean>> tempMap = new HashMap<>();
        List<OpenServerBean.InfoBean> beanInfo = bean.getInfo();
        for (int i = 0; i < beanInfo.size(); i++) {
            OpenServerBean.InfoBean infoBean = beanInfo.get(i);
            String key = infoBean.getAddtime();
            if (!tempMap.containsKey(key)) {
                keyList.add(key);
                ArrayList<OpenServerBean.InfoBean> infoList = new ArrayList<>();
                infoList.add(infoBean);
                tempMap.put(key,infoList);
            } else {
                tempMap.get(key).add(infoBean);
            }
        }
        return tempMap;

    }

    class MyAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return keyList == null?0:keyList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            String key = keyList.get(groupPosition);
            List<OpenServerBean.InfoBean> infoBeenList = map.get(key);
            return infoBeenList == null?0:infoBeenList.size();
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
            TextView textView = (TextView) convertView;
            if (textView == null) {
                textView = new TextView(MainActivity.this);
            }
            textView.setText(keyList.get(groupPosition));
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = (TextView) convertView;
            if (textView == null) {
                textView = new TextView(MainActivity.this);
            }
            textView.setText("sssss");
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
