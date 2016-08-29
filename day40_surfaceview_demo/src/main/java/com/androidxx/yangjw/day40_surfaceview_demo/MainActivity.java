package com.androidxx.yangjw.day40_surfaceview_demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * SurfaceView的基本使用
 */
public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private static final String TAG = "androidxx";
    private SurfaceView mSurfaceView;
    private Paint mPaint;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);
        //召唤经纪人
        SurfaceHolder holder = mSurfaceView.getHolder();

        //等待经纪人准备就绪
        holder.addCallback(this);

        //创建一个画笔
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
    }

    /**
     * SurfaceView初始化完毕之后
     * Holder准备就绪
     * @param holder
     */
    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i < 100) {
                    /**
                     * 锁定画布，并且返回了一个Canvas对象
                     */
                    Log.i(TAG, "run: ");
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawCircle(200+10*i,200+10*i,150,mPaint);
                    //解锁画布，并且将画布发送给surfaceview显示
                    holder.unlockCanvasAndPost(canvas);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }

            }
        }).start();


    }

    /**
     * 当SurfaceView发生变化时
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * SurfaceView被销毁时，回调的方法
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        i = 101;
    }
}
