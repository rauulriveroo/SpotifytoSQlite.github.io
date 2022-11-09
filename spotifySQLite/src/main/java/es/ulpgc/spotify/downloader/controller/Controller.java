package es.ulpgc.spotify.downloader.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.ulpgc.spotify.downloader.api.SpotifyAccessor;
import es.ulpgc.spotify.downloader.model.Album;
import es.ulpgc.spotify.downloader.model.Artist;
import es.ulpgc.spotify.downloader.model.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    public static Artist GetArtists(String id) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/" + id, Map.of());
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(response, JsonObject.class);
        String name = object.getAsJsonObject().get("name").getAsString();
        String type = object.getAsJsonObject().get("type").getAsString();
        int popularity = object.getAsJsonObject().get("popularity").getAsInt();

        return new Artist(id, name, type, popularity);
    }
    public static List<Track> GetTracks(String artistId) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/" + artistId + "/albums", Map.of());
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        JsonArray items = jsonObject.get("items").getAsJsonArray();
        List<Track> tracks = new ArrayList<>();
        for (JsonElement item : items) {
            String albumId = item.getAsJsonObject().get("id").getAsString();
            String response1 = accessor.get("/albums/" + albumId + "/tracks", Map.of());
            JsonObject jsonObject1 = new Gson().fromJson(response1, JsonObject.class);
            JsonArray items1 = jsonObject1.get("items").getAsJsonArray();
            for (JsonElement item0 : items1) {
                String id = item0.getAsJsonObject().get("id").getAsString();
                String name = item0.getAsJsonObject().get("name").getAsString();
                int duration_ms = item0.getAsJsonObject().get("duration_ms").getAsInt();
                Track track = new Track(name, id, duration_ms);
                tracks.add(track);
            }
        }
        return tracks;
    }

    public static List<Album> GetAlbums(String artistId) throws Exception{
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/"+ artistId + "/albums",Map.of());
        JsonObject object = new Gson().fromJson(response, JsonObject.class);
        List<Album> albums = new ArrayList<>();
        JsonArray items = object.get("items").getAsJsonArray();
        for (JsonElement item:items) {
            String album_type = item.getAsJsonObject().get("album_type").getAsString();
            if (album_type.equals("album")) {
                String name = item.getAsJsonObject().get("name").getAsString();
                String id = item.getAsJsonObject().get("id").getAsString();
                String release_date = item.getAsJsonObject().get("release_date").getAsString();
                int total_tracks = item.getAsJsonObject().get("total_tracks").getAsInt();
                Album album = new Album(album_type, id, name, release_date, total_tracks);
                albums.add(album);
            }
        }
        return albums;
    }
}