package com.example.markqueltaylor.macmusicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {


    public SongAdapter(Context context, int list_song, ArrayList<Song> songs) {
        super(context, 0, songs);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        View listItemView = convertView;

        // Checking if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_song, parent, false);
        }

        // Getting the current meaning in the list
        final Song currentSong = getItem(position);


        // Find the TextView in the list_item
        TextView songTitle = listItemView.findViewById(R.id.songTitle);
        TextView artistName = listItemView.findViewById(R.id.artistName);
        TextView songTime = listItemView.findViewById(R.id.songTime);


        //Setting the song details in music selection
        songTitle.setText(currentSong.getSongTitle());
        artistName.setText(currentSong.getArtistName());
        songTime.setText(currentSong.getSongTime());

        listItemView.setTag(position);
        // Attach the click event handler
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), NowPlaying.class);
                i.putExtra("artistName", currentSong.getArtistName());
                i.putExtra("songTitle", currentSong.getSongTitle());
                i.putExtra("songTime", currentSong.getSongTime());
                getContext().startActivity(i);
            }
        });
        // ... other view population as needed...
        // Return the completed view
        return listItemView;
    }


}
