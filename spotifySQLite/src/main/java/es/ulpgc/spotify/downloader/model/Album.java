package es.ulpgc.spotify.downloader.model;


public class Album {
    public String album_type;
    public String id;
    public String name;
    public String release_date;
    public int total_tracks;


    public Album(String album_type, String id, String name, String release_date, int total_tracks) {
        this.album_type = album_type;
        this.id = id;
        this.name = name;
        this.release_date = release_date;
        this.total_tracks = total_tracks;
    }
}
