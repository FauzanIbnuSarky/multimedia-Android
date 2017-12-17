package com.example.muqorrobinaimar.multimedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoSederhanaActivity extends AppCompatActivity {

    @BindView(R.id.videoSederhana)
    VideoView videoSederhana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_video_sederhana);
        ButterKnife.bind(this);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        MediaController controller = new MediaController(VideoSederhanaActivity.this);
        controller.setAnchorView(videoSederhana);

        videoSederhana.setMediaController(controller);
        videoSederhana.setVideoURI(uri);
        videoSederhana.requestFocus();
        videoSederhana.start();
    }
}
