package com.example.mac.udacitymovieapp1.model;

/**
 * Created by mac on 6/02/18.
 */

public class Movie {

    private String image_link;
    private String movieName;
    private String poster_path;

    public Movie(String image_link, String movieName, String poster_path) {
        this.image_link = image_link;
        this.movieName = movieName;
        this.poster_path = poster_path;

    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
