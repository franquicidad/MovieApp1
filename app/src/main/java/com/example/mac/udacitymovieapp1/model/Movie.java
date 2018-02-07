package com.example.mac.udacitymovieapp1.model;

/**
 * Created by mac on 6/02/18.
 */

public class Movie {

    private String image_link;
    private String movieName;

    public Movie(String image_link, String movieName) {
        this.image_link = image_link;
        this.movieName = movieName;
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
}
