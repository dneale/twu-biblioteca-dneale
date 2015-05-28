package com.twu.biblioteca;

import junit.framework.TestCase;

public class BibliotecaAppTest extends TestCase {

    public void testCommandReturnBook() throws Exception {
        BibliotecaApp app = new BibliotecaApp();

        // Non-existent book
        assertEquals("That is not a valid book to return.", app.commandReturnBook("Fake Book"));

        app.commandCheckoutBook("Test Book");
        assertEquals("Thank you for returning the book.", app.commandReturnBook("Test Book"));

        // Return book that isn't checked out
        assertEquals("That is not a valid book to return.", app.commandReturnBook("Test Book"));

    }

    public void testCommandCheckoutBook() throws Exception {
        BibliotecaApp app = new BibliotecaApp();

        // Non-existent book
        assertEquals("That book is not available.", app.commandCheckoutBook("Fake Book"));

        // Basic Check out
        assertEquals("Thank you! Enjoy the book.", app.commandCheckoutBook("Test Book"));
    }

    public void testListBooks() throws Exception {

        BibliotecaApp app = new BibliotecaApp();

        // basic test
        assertEquals("BOOK LIST (name, author, year published):\n" +
                        "Test Book, Doug Neale, 2015\n" +
                        "The Hunger Games, Suzanne Collins, 2008\n" +
                        "1984, George Orwell, 1949\n",
                app.listBooks());

        // remove from library and check if listed
        app.commandCheckoutBook("Test Book");
        assertEquals("BOOK LIST (name, author, year published):\n" +
                        "The Hunger Games, Suzanne Collins, 2008\n" +
                        "1984, George Orwell, 1949\n",
                app.listBooks());

        // return and see if back in library
        app.commandReturnBook("Test Book");
        assertEquals("BOOK LIST (name, author, year published):\n" +
                        "Test Book, Doug Neale, 2015\n" +
                        "The Hunger Games, Suzanne Collins, 2008\n" +
                        "1984, George Orwell, 1949\n",
                app.listBooks());

    }
}