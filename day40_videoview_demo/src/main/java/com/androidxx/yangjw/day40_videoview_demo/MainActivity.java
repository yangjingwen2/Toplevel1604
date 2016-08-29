package com.androidxx.yangjw.day40_videoview_demo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * VideoView基本使用
 */
public class MainActivity extends AppCompatActivity {

    public static final String URI = "http://mvvideo1.meitudata.com/57bfff5c69171354.mp4";
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.video_view);
        //配置视频地址
        mVideoView.setVideoURI(Uri.parse(URI));
        //配置视频播放的控制条
        MediaController controller = new MediaController(this);
        mVideoView.setMediaController(controller);
        //开始播放
        mVideoView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //视屏播放暂停
        mVideoView.pause();
    }
}
