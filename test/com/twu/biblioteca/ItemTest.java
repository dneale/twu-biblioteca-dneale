package com.twu.biblioteca;

import junit.framework.TestCase;

/**
 * Created by dmn on 3/06/15.
 */
public class ItemTest extends TestCase {

    public void testGetTitle() throws Exception {
        Item b = new Item("Test Item");
        assertEquals("Test Item", b.getTitle());
    }

    public void testIsCheckedOut() throws Exception {
        Item b = new Item("Test Item");
        assertFalse(b.isCheckedOut());
    }

    public void testCheckOut() throws Exception {
        Item b = new Item("Test Item");
        User u = new User(1, "password", "doug", "dougneale@gmail.com", "1234 1234");
        b.checkOut(u);
        assertTrue(b.isCheckedOut());
    }

    public void testCheckIn() throws Exception {
        Item b = new Item("Test Item");
        User u = new User(1, "password", "doug", "dougneale@gmail.com", "1234 1234");
        b.checkOut(u);
        b.checkIn();
        assertFalse(b.isCheckedOut());
    }

    public void testGetBorrowingUser() throws Exception {
        Item b = new Item("Test Item");
        User u = new User(1, "password", "doug", "dougneale@gmail.com", "1234 1234");

        assertEquals(b.getBorrowingUser(), null);
        b.checkOut(u);
        assertEquals(b.getBorrowingUser(), u);
        b.checkIn();
        assertEquals(b.getBorrowingUser(), null);
    }
}