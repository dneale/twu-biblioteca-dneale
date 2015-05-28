package com.twu.biblioteca;

import com.twu.BookCheckedOutException;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by dmn on 28/05/15.
 */
public class BookTest extends TestCase {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetName() throws Exception {
        Book b = new Book("Test Book");
        assertEquals("Test Book", b.getName());
    }

    @Test
    public void testIsCheckedOut() throws Exception {
        Book b = new Book("Test Book");
        assertFalse(b.isCheckedOut());
    }

    @Test
    public void testCheckOut() throws Exception {
        Book b = new Book("Test Book");
        b.checkOut();
        assertTrue(b.isCheckedOut());
    }

//    @Test(expected=BookCheckedOutException.class)
//    public void testCheckOutThrowsException() throws Exception {
//        Book b = new Book("Test Book");
//        b.checkOut();
//        b.checkOut();
//
//    }

    @Test
    public void testCheckIn() throws Exception {
        Book b = new Book("Test Book");
        b.checkOut();
        b.checkIn();
        assertFalse(b.isCheckedOut());
    }

}