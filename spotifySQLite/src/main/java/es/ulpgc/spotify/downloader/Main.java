package es.ulpgc.spotify.downloader;

import es.ulpgc.spotify.downloader.sqlite.SQLiteMusicDatabase;
import es.ulpgc.spotify.downloader.controller.Controller;
import es.ulpgc.spotify.downloader.model.Album;
import es.ulpgc.spotify.downloader.model.Artist;
import es.ulpgc.spotify.downloader.model.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        SQLiteMusicDatabase sqLiteMusicDatabase = new SQLiteMusicDatabase();
        sqLiteMusicDatabase.init();

        List<String> artistId = Arrays.asList("0Q8NcsJwoCbZOHHW63su5S", "2LRoIwlKmHjgvigdNGBHNo", "5XJDexmWFLWOkjOEjOVX3e", "7iK8PXO48WeuP03g8YR51W", "52iwsT98xCoGgiGntTiR7K");
        List<Artist> artists = new ArrayList<>();
        for (String s : artistId) {
            artists.add(Controller.GetArtists(s));
        }


        for (Artist artist : artists) {
            sqLiteMusicDatabase.insertArtist(artist);
        }

        List<Album> albums;
        for (String s : artistId) {
            albums = Controller.GetAlbums(s);
            for (Album album : albums) {
                sqLiteMusicDatabase.insertAlbums(album);
            }
        }

        List<Track> tracks;
        for (String s : artistId) {
            tracks = Controller.GetTracks(s);
            for (Track track : tracks) {
                sqLiteMusicDatabase.insertTracks(track);
            }
        }
    }
}
