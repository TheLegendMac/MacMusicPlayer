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

        songTitle.setTag(position);
        // Attach the click event handler
        songTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();
                Intent i = new Intent(view.getContext(), NowPlaying.class);
                for (int index = 0; index < 16; index++) {
                    if (position == index) {
                        i.putExtra("ArtistName", currentSong.getArtistName());
                        i.putExtra("SongTitle", currentSong.getSongTitle());
                        i.putExtra("SongTime", currentSong.getSongTime());
                    }
                }
            }
        });
        // ... other view population as needed...
        // Return the completed view
        return listItemView;
    }


}
