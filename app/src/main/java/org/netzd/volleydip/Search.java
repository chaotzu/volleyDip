package org.netzd.volleydip;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alumno12 on 03/03/18.
 */

public class Search {
    @SerializedName("Search")
    private List<Video> videos = null;

    public Search() {
    }

    public Search(List<Video> videos) {
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
