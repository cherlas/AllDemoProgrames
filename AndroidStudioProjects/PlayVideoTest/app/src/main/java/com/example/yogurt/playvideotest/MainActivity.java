package com.example.yogurt.playvideotest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button play,pause,replay;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play= (Button) findViewById(R.id.play);
        pause= (Button) findViewById(R.id.pause);
        replay= (Button) findViewById(R.id.replay);
        videoView= (VideoView) findViewById(R.id.video_view);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPlayer();
    }

    private void initVideoPlayer() {
        File video=new File(Environment.getExternalStorageDirectory(),"movie.3gp");
        videoView.setVideoPath(video.getPath());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if (!videoView.isPlaying())
                    videoView.start();
                break;
            case R.id.pause:
                if (videoView.isPlaying())
                    videoView.pause();
                else if (!videoView.isPlaying())
                    videoView.start();
                break;
            case R.id.replay:
                videoView.resume();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.suspend();
    }
}
