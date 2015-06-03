package com.twu.biblioteca;

import junit.framework.TestCase;


public class BookTest extends TestCase {

    public void testGetAuthor() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        assertEquals("Doug Neale", b.getAuthor());
    }

    public void testGetYearPublished() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        assertEquals("2015", b.getYearPublished());
    }
}