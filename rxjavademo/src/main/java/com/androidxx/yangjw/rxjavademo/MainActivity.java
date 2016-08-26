package com.androidxx.yangjw.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * RxJava基本使用
 * 步骤：
 * 1、导包
 * 2、创建一个观察者对象
 * 3、创建一个被观察者对象
 * 4、建立观察者和被观察者关联关系
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "androidxx";
    Subscriber<String> subscriber;
    Observable<String> observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        method1();
//        method2();
//        method3();
        method4();

    }


    private void method4() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("zhangsan");
            }
        }).map(new Func1<String, Object>() {
            @Override
            public Object call(String s) {
                return s + ":lisi";
            }
        }).map(new Func1<Object, String>() {
            @Override
            public String call(Object o) {
                return "----" + o;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG, "call: " + s);
            }
        });

    }

    private void method3() {
        Observable.just("zhangsan")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, "onNext: " + s);
                    }
                });
    }

    private void method2() {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                Log.i(TAG, "call999: " + Thread.currentThread().getName());
                subscriber.onNext("ssssss");
            }
        })
                .observeOn(Schedulers.newThread()) //表示被观察者运行在子痫中
                .subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, "onNext: " + o);
                Log.i(TAG, "call1111: " + Thread.currentThread().getName());
            }
        });
    }

    private void method1() {
        //观察者对象
        subscriber = new Subscriber<String>() {
            /**
             * 监听结束
             * 观察结束
             */
            @Override
            public void onCompleted() {

            }

            /**
             * 监听过程中出现异常执行此方法
             * 观察中出现的异常
             * @param e
             */
            @Override
            public void onError(Throwable e) {

            }

            /**
             * 监听后获得结果的方法
             * 观察之后的反馈
             * @param s
             */
            @Override
            public void onNext(String s) {
                Log.i(TAG, "subscriber---->onNext: " + Thread.currentThread().getName());
            }
        };

        //被观察者
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            /**
             * 被观察者主要的方法（被观察者的一些业务逻辑可以写在此方法中）
             * 触发观察者
             * @param subscriber 观察者对象
             */
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("zhangsan");
                Log.i(TAG, "Observable--->onNext: " + Thread.currentThread().getName());
            }
        });
    }

    public void click(View view) {
        //关联
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())//开启一个子线程
                .subscribe(subscriber);
    }
}
