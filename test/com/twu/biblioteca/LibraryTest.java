package com.twu.biblioteca;

import junit.framework.TestCase;

public class LibraryTest extends TestCase {

    public void testFindBook() throws Exception {
        Library lib = new Library();
        Book b = lib.findBook("Test Book");
        assertEquals(b.getName(), "Test Book");
    }
}