package com.twu.biblioteca;

import com.twu.BookCheckedOutException;

/**
 * Created by dmn on 28/05/15.
 */
public class Book {

    private boolean checkedOut;
    private String name;
    private String author;
    private String yearPublished;

    public Book(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() throws BookCheckedOutException {
        if (checkedOut)
            throw new BookCheckedOutException();
        this.checkedOut = true;
    }
    public void checkIn() {
        this.checkedOut = false;
    }

}
