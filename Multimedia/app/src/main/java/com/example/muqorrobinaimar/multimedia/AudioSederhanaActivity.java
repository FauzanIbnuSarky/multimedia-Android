package com.example.muqorrobinaimar.multimedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AudioSederhanaActivity extends AppCompatActivity {

    @BindView(R.id.btnStop)
    Button btnStop;
    @BindView(R.id.btnPause)
    Button btnPause;
    @BindView(R.id.btnResume)
    Button btnResume;
    @BindView(R.id.btnPlay)
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_sederhana);
        ButterKnife.bind(this);
        uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.music);
        enable(btnPlay);
        disable(btnPause, btnResume, btnStop);
    }

    //variable global


    Uri uri = null;
    MediaPlayer player;


    @OnClick({R.id.btnStop, R.id.btnPause, R.id.btnResume, R.id.btnPlay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                //mejalankan
                player= new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    player.setDataSource(getApplicationContext(),uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                enable(btnPause, btnStop);
                disable(btnPlay, btnResume);
                player.start();
                break;

            case R.id.btnStop:
                if (player.isPlaying() && player !=null){
                    player.stop();
                }
                enable(btnPlay);
                disable(btnResume, btnStop, btnPause);
                break;

            case R.id.btnPause:
                if (player.isPlaying()){
                    player.pause();
                }
                enable(btnResume);
                disable(btnPlay, btnStop, btnPause);
                break;

            case R.id.btnResume:
                player.start();
                enable(btnPause, btnStop);
                disable(btnResume, btnPlay);

                break;

        }
    }
    private void enable(View... views){
        for (View v : views){
            v.setEnabled(true);
        }
    }
    private void disable(View... views) {
        for (View v : views) {
            v.setEnabled(false);
        }
    }

}
