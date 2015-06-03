package com.twu.biblioteca;

public class Book extends Item {

    private String author;
    private String yearPublished;


    public Book(String title, String author, String yearPublished) {
        super(title);
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }


}
