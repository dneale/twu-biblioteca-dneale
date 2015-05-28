package com.twu.biblioteca;

/**
 * Created by dmn on 28/05/15.
 */
public class BibliotecaCLI {

    private static String welcomeMessage = "Welcome to Biblioteca!";

    public BibliotecaCLI() {}


    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void showBooks(Library lib) {
        System.out.println("BOOK LIST:");
        for (Book book : lib.getBookList()) {
            System.out.println(book.getName());
        }
    }
}
