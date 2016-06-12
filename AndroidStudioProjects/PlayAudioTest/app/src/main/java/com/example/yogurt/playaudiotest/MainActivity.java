package com.example.yogurt.playaudiotest;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play,pause,stop;
    private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play= (Button) findViewById(R.id.play);
        pause= (Button) findViewById(R.id.pause);
        stop= (Button) findViewById(R.id.stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        initMediaPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
            }


        }
    }

    private void initMediaPlayer() {

        try {
            File mp3File=new File(Environment.getExternalStorageDirectory(),"music.mp3");
            mediaPlayer.setDataSource(mp3File.getPath());
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if (!mediaPlayer.isPlaying())
                mediaPlayer.start();
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
                else if (!mediaPlayer.isPlaying())
                    mediaPlayer.start();
                break;
            case R.id.stop:
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                break;
        }
    }
}
