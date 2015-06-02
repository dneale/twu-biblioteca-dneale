package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;

    public Library() {
        initBookList();
    }

    private void initBookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Test Book", "Doug Neale", "2015"));
        bookList.add(new Book("The Hunger Games", "Suzanne Collins", "2008"));
        bookList.add(new Book("1984", "George Orwell", "1949"));
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public Book findBook(String name) throws BookNotFoundException {
        for (Book b : getBookList()) {
            if (b.getTitle().equals(name)) {
                return b;
            }
        }
        throw new BookNotFoundException();
    }
}
