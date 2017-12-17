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

public class AudioActivity extends AppCompatActivity {

    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnStop)
    Button btnStop;
    //variable global
    Uri uri = null;
    MediaPlayer player;
    String PLAY = "PLAY", PAUSE="PAUSE", RESUME="RESUME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        ButterKnife.bind(this);
        uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.music);
        btnPlay.setText(PLAY);
    }

    @OnClick({R.id.btnPlay, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                if (btnPlay.getText().toString().equals(PLAY)){
                    btnPlay.setText(PAUSE);
                    //menjalankan
                    player = new MediaPlayer();
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        player.setDataSource(getApplicationContext(), uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.start();
                }else if (btnPlay.getText().toString().equals(PAUSE)){
                    btnPlay.setText(RESUME);
                    if (player.isPlaying()){
                        player.pause();
                    }
                }else if (btnPlay.getText().toString().equals(RESUME)){
                    btnPlay.setText(PAUSE);
                    player.start();
                }
                break;
            case R.id.btnStop:
                if (player.isPlaying() && player !=null){
                    player.stop();
                }
                btnPlay.setText(PLAY);
                break;
        }
    }
}