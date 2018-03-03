package org.netzd.volleydip;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alumno12 on 24/02/18.
 */

public class Video {

    @SerializedName("imdbID") //Se utiliza en caso de que el atributo en el objeto json no se llame igual que en nuestra clase
    private String id=null;
    @SerializedName("Title")
    private String title=null;
    @SerializedName("Year")
    private String year=null;
    @SerializedName("Type")
    private String type=null;
    @SerializedName("Poster")
    private String poster=null;
    private String Realased = null; //En este caso no se agrega Serialized por que se llama igual
    @SerializedName("Writer")
    private String director = null;
    private String Actors = null;
    //private List<Rating> Ratings = null;

    public Video() {
    }

    public Video(String id, String title, String year, String type, String poster) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}


