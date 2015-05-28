package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BookTest extends TestCase {

    public void testGetName() throws Exception {
        Book b = new Book("Test Book", "Doug Neale", "2015");
        assertEquals("Test Book", b.getName());
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