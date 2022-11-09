package es.ulpgc.spotify.downloader.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import es.ulpgc.spotify.downloader.api.SpotifyAccessor;

import java.util.List;
import java.util.Map;

public class Track {
    public String name;
    public String id;
    public int duration_ms;

    public Track(String name, String id, int duration_ms) {
        this.name = name;
        this.id = id;
        this.duration_ms = duration_ms;
    }

}
