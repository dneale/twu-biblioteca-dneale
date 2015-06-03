package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<User> userList;

    public Library() {
        initBookList();
        initMovieList();
        initUserList();
    }

    private void initBookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Test Book", "Doug Neale", "2015"));
        bookList.add(new Book("The Hunger Games", "Suzanne Collins", "2008"));
        bookList.add(new Book("1984", "George Orwell", "1949"));
    }
    private void initMovieList() {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Test Movie", "Doug Neale", "2015", 9));
        movieList.add(new Movie("Inception", "Christopher Nolan", "2009", 9));
        movieList.add(new Movie("The Matrix", "The Wachoski Brothers", "1999", 0));
    }

    private void initUserList() {
        userList = new ArrayList<User>();
        userList.add(new User(1, "password", "doug", "dougneale@gmail.com"));
    }


    public ArrayList<Book> getBookList() {
        return bookList;
    }
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
    public ArrayList<User> getUserList() {
        return userList;
    }

    public Book findBook(String name) throws ItemNotFoundException {
        for (Book b : getBookList()) {
            if (b.getTitle().equals(name)) {
                return b;
            }
        }
        throw new ItemNotFoundException();
    }

    public Book findMovie(String name) throws ItemNotFoundException {
        for (Book b : getBookList()) {
            if (b.getTitle().equals(name)) {
                return b;
            }
        }
        throw new ItemNotFoundException();
    }
}
