package com.example.muqorrobinaimar.multimedia;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoStreamingActivity extends AppCompatActivity {

    @BindView(R.id.ideoStreaming)
    VideoView VideoStreaming;
    String url = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
    ProgressDialog progressDialog;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
        ButterKnife.bind(this);

        //kita siapkan si progressnya
        progressDialog = new ProgressDialog(VideoStreamingActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Sabar ya dek ku....");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        //set Controller
        MediaController controller = new MediaController(VideoStreamingActivity.this);
        controller.setAnchorView(VideoStreaming);
        VideoStreaming.setMediaController(controller);
        //kita siapkan alamat nya
        Uri uri = Uri.parse(url);
        VideoStreaming.setVideoURI(uri);
        VideoStreaming.requestFocus();
        VideoStreaming.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }
}