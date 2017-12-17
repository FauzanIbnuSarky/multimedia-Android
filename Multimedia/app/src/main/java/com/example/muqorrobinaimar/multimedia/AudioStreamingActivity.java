package com.example.muqorrobinaimar.multimedia;

    import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ProgressBar;

        import java.io.IOException;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;

public class AudioStreamingActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnPlayStreaming)
    Button btnPlayStreaming;
    @BindView(R.id.btnStopStreaming)
    Button btnStopStreaming;

    //Variable global
    MediaPlayer player;
    // String url = "http://rri.co.id/stream/pro4jakarta";
    String url = "http://103.16.198.36:9160/stream";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_streaming);
        ButterKnife.bind(this);
        progressBar.setMax(100);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setIndeterminate(false);
        btnStopStreaming.setEnabled(false);
        setPutar();
    }

    private void setPutar() {
        player = new MediaPlayer();
        try {
            player.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                progressBar.setIndeterminate(true);
                progressBar.setSecondaryProgress(100);
            }
        });
    }
    @OnClick({R.id.btnPlayStreaming, R.id.btnStopStreaming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlayStreaming:
                btnStopStreaming.setEnabled(true);
                btnPlayStreaming.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
                player.prepareAsync();
                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                        progressBar.setIndeterminate(false);
//                        progressBar.setVisibility(View.INVISIBLE);
//                        progressBar.setIndeterminate(true);
                    }
                });
                break;
            case R.id.btnStopStreaming:
                if (player == null) return;
                if (player.isPlaying()) {
                    player.stop();
                    player.release();
                    setPutar();
                    progressBar.setVisibility(View.INVISIBLE);
                    progressBar.setIndeterminate(true);
                    btnPlayStreaming.setEnabled(true);
                    btnStopStreaming.setEnabled(false);
                }

                break;
        }
    }
}