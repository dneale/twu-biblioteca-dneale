package com.twu.biblioteca;

public class Book {

    private boolean checkedOut;
    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut()  {
        this.checkedOut = true;
    }

    public void checkIn() {
        this.checkedOut = false;
    }

}
