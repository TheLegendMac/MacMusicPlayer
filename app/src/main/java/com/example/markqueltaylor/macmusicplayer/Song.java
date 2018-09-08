package com.example.markqueltaylor.macmusicplayer;

class Song {
    private String songTitle, artistName, songTime;


    Song(String songTitle, String artistName, String songTime) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.songTime = songTime;
    }


    public String getSongTime() {
        return songTime;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongTitle() {

        return songTitle;
    }
}
