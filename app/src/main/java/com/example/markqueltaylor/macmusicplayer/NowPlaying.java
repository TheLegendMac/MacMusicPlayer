package com.example.markqueltaylor.macmusicplayer;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    private static final String TAG = "NowPlayingActivity";
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        final TextView artistName = findViewById(R.id.artistName);
        final TextView songTitle = findViewById(R.id.songTitle);
        final TextView songTime = findViewById(R.id.songTime);
        final ImageButton playbackButton = findViewById(R.id.playbackButton);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            Log.v("NowPlaying", "Item Clicked!!!!!!!!!!!!!!!!!!");
            artistName.setText(bundle.getString("artistName"));
            songTitle.setText(bundle.getString("songTitle"));
            songTime.setText(bundle.getString("songTime"));
        }

        playbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressBar progressBar = findViewById(R.id.progressBar);
                // Start long running operation in a background thread
                new Thread(new Runnable() {
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 1;
                            // Update the progress bar and display the
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                }
                            });
                            try {
                                // Sleep for 50 milliseconds.
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });

    }
}
