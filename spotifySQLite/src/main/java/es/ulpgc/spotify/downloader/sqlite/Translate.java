package es.ulpgc.spotify.downloader.sqlite;

import es.ulpgc.spotify.downloader.model.Album;
import es.ulpgc.spotify.downloader.model.Artist;
import es.ulpgc.spotify.downloader.model.Track;

public class Translate {
    private static final String INSERT_ARTIST =
            "INSERT INTO artists(name, id, popularity, type) VALUES('%s', '%s', '%d', '%s');";

    public static String insertArtist(Artist artist){
        return String.format(INSERT_ARTIST,
                artist.name,
                artist.id,
                artist.popularity,
                artist.type);
    }


    private static final String INSERT_ALBUM =
            "INSERT INTO albums(name, album_type, release_date, total_tracks) VALUES('%s', '%s', '%s', '%d')";
    public static String insertAlbum(Album album){
        return String.format(INSERT_ALBUM,
                album.name,
                album.album_type,
                album.release_date,
                album.total_tracks);
    }

    private static final String INSERT_TRACK =
            "INSERT INTO tracks(name, id, duration_ms) VALUES('%s', '%s', '%d')";
    public static String insertTrack(Track track){
        return String.format(INSERT_TRACK,
                track.name,
                track.id,
                track.duration_ms);
    }

}
