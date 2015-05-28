package com.twu.biblioteca;

public class Book {

    private boolean checkedOut;
    private String name;
    private String author;
    private String yearPublished;

    public Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
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
