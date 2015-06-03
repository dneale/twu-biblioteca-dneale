package com.twu.biblioteca;

import junit.framework.TestCase;

/**
 * Created by dmn on 3/06/15.
 */
public class MovieTest extends TestCase {

    public void testGetYearReleased() throws Exception {
        Movie m = new Movie("Inception", "Chris Nolan", "2012", 9);
        assertEquals("2012", m.getYearReleased());
    }

    public void testGetDirector() throws Exception {
        Movie m = new Movie("Inception", "Chris Nolan", "2012", 9);
        assertEquals("Chris Nolan", m.getDirector());
    }

    public void testGetRating() throws Exception {
        Movie m = new Movie("Inception", "Chris Nolan", "2012", 9);
        assertEquals(9, m.getRating());
    }
}