package com.example.markqueltaylor.macmusicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    private static final String TAG = "NowPlayingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        final TextView artistName = findViewById(R.id.artistName);
        final TextView songTitle = findViewById(R.id.songTitle);
        final TextView songTime = findViewById(R.id.songTime);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            Log.v("NowPlaying", "Item Clicked!!!!!!!!!!!!!!!!!!");
            artistName.setText(bundle.getString("artistName"));
            songTitle.setText(bundle.getString("songTitle"));
        }

    }
}
