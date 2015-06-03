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
        b.checkOut();
        assertTrue(b.isCheckedOut());
    }

    public void testCheckIn() throws Exception {
        Item b = new Item("Test Item");
        b.checkOut();
        b.checkIn();
        assertFalse(b.isCheckedOut());
    }
}