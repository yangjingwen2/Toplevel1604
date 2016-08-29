package com.androidxx.yangjw.day40_custom_videoview_demo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * SurfaceView结合MediaPlayer完成视频播放
 */
public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback,MediaPlayer.OnPreparedListener{

    public static final String URI = "http://mvvideo1.meitudata.com/57bfff5c69171354.mp4";
    private SurfaceView mSurfaceView;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMediaPlayer();
    }

    private void initMediaPlayer() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.reset();

    }

    private void initView() {
        mSurfaceView = (SurfaceView) findViewById(R.id.video_surface_view);
        SurfaceHolder surfaceHolder = mSurfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    /**
     *
     * @param holder 已经就绪的Holder对象
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mMediaPlayer.setDataSource(this, Uri.parse(URI));
            //异步准备
            mMediaPlayer.prepareAsync();
            //监听MediaPlayer准备就绪的结果
            mMediaPlayer.setOnPreparedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //配置MediaPlayer的视图显示
        mMediaPlayer.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mMediaPlayer.pause();
    }

    /**
     * MediaPlayer异步准备就绪后的监听方法
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
    }
}
