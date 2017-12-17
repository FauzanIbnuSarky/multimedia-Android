package com.example.muqorrobinaimar.multimedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnAudioSederhana)
    Button btnAudioSederhana;
    @BindView(R.id.btnAudio)
    Button btnAudio;
    @BindView(R.id.btnAudioStreaming)
    Button btnAudioStreaming;
    @BindView(R.id.btnVideoSederhana)
    Button btnVideoSederhana;
    @BindView(R.id.btnVideoStreaming)
    Button btnVideoStreaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnAudioSederhana, R.id.btnAudio, R.id.btnAudioStreaming, R.id.btnVideoSederhana, R.id.btnVideoStreaming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAudioSederhana:
                startActivity(new Intent(MainActivity.this, AudioSederhanaActivity.class));
                break;
            case R.id.btnAudio:
                startActivity(new Intent(MainActivity.this, AudioActivity.class));
                break;
            case R.id.btnAudioStreaming:
                startActivity(new Intent(MainActivity.this, AudioStreamingActivity.class));
                break;
            case R.id.btnVideoSederhana:
                startActivity(new Intent(MainActivity.this, VideoSederhanaActivity.class));

                break;
            case R.id.btnVideoStreaming:
                startActivity(new Intent(MainActivity.this, VideoStreamingActivity.class));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_audio:
                pesanku("AUDIO");

                break;
            case R.id.menu_exit:
                pesanku("EXIT");
                finish();
                break;

            case R.id.menu_video:
                pesanku("VIDEO");
                break;

        }
        return true;
    }

    void pesanku(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    void pindah(Class c){
        startActivity(new Intent(this, c));
    }
}

