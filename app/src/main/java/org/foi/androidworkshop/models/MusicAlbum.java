package org.foi.androidworkshop.models;

public class MusicAlbum {

    private String albumArtUrl;
    private String artist;
    private String album;
    private int year;

    public MusicAlbum() {}

    public MusicAlbum(String albumArtUrl, String artist, String album, int year) {
        this.albumArtUrl = albumArtUrl;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAlbumArtUrl() {
        return albumArtUrl;
    }

    public void setAlbumArtUrl(String albumArtUrl) {
        this.albumArtUrl = albumArtUrl;
    }
}
