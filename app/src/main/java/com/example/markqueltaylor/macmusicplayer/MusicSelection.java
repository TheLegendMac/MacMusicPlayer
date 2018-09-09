package com.example.markqueltaylor.macmusicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_selection);

        //Declaring array for the Music
        ArrayList<Song> songs = new ArrayList<Song>();

        //Initializing the elements of the array
        songs.add(new Song("My kind of Women", "Mac DeMarco", "4:98"));
        songs.add(new Song("This Old Dog", "Mac DeMarco", "4:98"));
        songs.add(new Song("Chamber of Reflection", "Mac DeMarco", "4:98"));
        songs.add(new Song("Rock and Roll Night Club", "Mac DeMarco", "4:98"));
        songs.add(new Song("Baby's Wearing Blue Jeans", "Mac DeMarco", "4:98"));
        songs.add(new Song("European Vegas", "Mac DeMarco", "4:98"));
        songs.add(new Song("I'm A Man", "Mac DeMarco", "4:98"));
        songs.add(new Song("Moving Like Mike", "Mac DeMarco", "4:44"));
        //Logging statements to verbose Logcat
        Log.i("MusicSelectionActivity", "Song ArrayList created with a total of " + songs.size() + " songs");

        SongAdapter adapter = new SongAdapter(this, R.layout.list_song, songs);


        final ListView listView = findViewById(R.id.rootView);
        listView.setAdapter(adapter);
    }
}
