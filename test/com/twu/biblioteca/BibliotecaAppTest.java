package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

public class BibliotecaAppTest extends TestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void testCommandReturnBook() throws Exception {
        BibliotecaApp app = new BibliotecaApp();

        // Non-existent book
        assertEquals("That is not a valid book to return.", app.commandReturnBook("Fake Book"));

        app.commandCheckoutBook("Test Book");
        assertEquals("Thank you for returning the book.", app.commandReturnBook("Test Book"));

        // Return book that isn't checked out
        assertEquals("That is not a valid book to return.", app.commandReturnBook("Test Book"));

    }

    @Test
    public void testCommandCheckoutBook() throws Exception {
        BibliotecaApp app = new BibliotecaApp();

        // Non-existent book
        assertEquals("That book is not available.", app.commandCheckoutBook("Fake Book"));

        // Basic Check out
        assertEquals("Thank you! Enjoy the book.", app.commandCheckoutBook("Test Book"));
    }

    @Test
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

    @Test
    public void testPrintWelcomeMessage() throws Exception {
        BibliotecaApp app  = new BibliotecaApp();
        app.printWelcomeMessage();
        assertEquals("Welcome to Biblioteca!\n\n", outContent.toString());
    }

    @Test
    public void testShowMenu() throws Exception {
        BibliotecaApp app  = new BibliotecaApp();
        app.showMenu();
        assertEquals("MENU LIST (select an option):\n" +
                "listbooks - list the currently available books\n" +
                "listmovies - list the currently available movies\n" +
                "checkout - check out a book\n" +
                "return - return a book\n" +
                "userinfo - view your information\n" +
                "exit - exit Biblioteca\n", outContent.toString());
    }

    @Test
    public void testRunPrompt() throws Exception {
        BibliotecaApp app  = new BibliotecaApp();
        ByteArrayInputStream in = new ByteArrayInputStream("exit\n".getBytes());
        System.setIn(in);
        app.run();
        assertEquals("Welcome to Biblioteca!\n" +
                "\n" +
                "BOOK LIST (name, author, year published):\n" +
                "Test Book, Doug Neale, 2015\n" +
                "The Hunger Games, Suzanne Collins, 2008\n" +
                "1984, George Orwell, 1949\n" +
                "\n" +
                "MENU LIST (select an option):\n" +
                "listbooks - list the currently available books\n" +
                "listmovies - list the currently available movies\n" +
                "checkout - check out a book\n" +
                "return - return a book\n" +
                "userinfo - view your information\n" +
                "exit - exit Biblioteca\n" +
                "Enter an option: Exiting\n", outContent.toString());
    }

    public void testLogIn() throws Exception {
        BibliotecaApp app  = new BibliotecaApp();
        assertTrue(app.login(1, "password"));
        assertEquals(1, app.getCurrentUser().getId());

        assertFalse(app.login(1, "wrong password"));
        assertFalse(app.login(99, "password"));

    }
}