package com.twu.biblioteca;

/**
 * Created by dmn on 3/06/15.
 */
public class Movie extends Item {
    private String yearReleased;
    private String director;
    private int rating;

    public Movie(String title, String director, String yearReleased, int rating) {
        super(title);
        this.yearReleased = yearReleased;
        this.director = director;
        this.rating = rating;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }
}
