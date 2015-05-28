package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by dmn on 28/05/15.
 */
public class Library {
    private ArrayList<Book> bookList;

    public Library() {
        initBookList();
    }

    private void initBookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Test Book"));
        bookList.add(new Book("The Hunger Games"));
        bookList.add(new Book("1984"));
        bookList.add(new Book("The Holy Bible"));
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
