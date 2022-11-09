package es.ulpgc.spotify.downloader.sqlite;

import es.ulpgc.spotify.downloader.model.Album;
import es.ulpgc.spotify.downloader.model.Artist;
import es.ulpgc.spotify.downloader.model.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteMusicDatabase {
    private Connection conn;
    public void init() throws SQLException {
        String dbPath = "C:/Users/rauul/.vscode/spotifySQLite/src/main/java/es/ulpgc/spotify/downloader/table.db";
        conn = connect(dbPath);
        Statement statement = conn.createStatement();
        createTable(statement);
    }

    private Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertArtist(Artist artist) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(Translate.insertArtist(artist));
    }

    public void insertAlbums(Album album) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(Translate.insertAlbum(album));
    }

    public void insertTracks(Track track) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(Translate.insertTrack(track));
    }

    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS artists (" +
                "name TEXT," +
                "id TEXT," +
                "popularity NUMBER," +
                "type TEXT" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS albums (" +
                "name TEXT," +
                "album_type TEXT," +
                "release_date TEXT," +
                "total_tracks NUMBER" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS tracks (" +
                "name TEXT," +
                "id TEXT," +
                "duration_ms NUMBER" +
                ");");
    }
}