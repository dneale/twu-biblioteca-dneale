package com.twu.biblioteca;

import junit.framework.TestCase;


public class BookTest extends TestCase {

    public void testGetTitle() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        assertEquals("Test Book", b.getTitle());
    }

    public void testIsCheckedOut() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        assertFalse(b.isCheckedOut());
    }

    public void testCheckOut() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        b.checkOut();
        assertTrue(b.isCheckedOut());
    }

    public void testCheckIn() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        b.checkOut();
        b.checkIn();
        assertFalse(b.isCheckedOut());
    }

}