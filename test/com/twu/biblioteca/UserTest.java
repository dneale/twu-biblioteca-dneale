package com.twu.biblioteca;

import junit.framework.TestCase;

/**
 * Created by dmn on 3/06/15.
 */
public class UserTest extends TestCase {

    User u;

    public void setUp() throws Exception {
        super.setUp();
        u = new User(1, "password", "doug", "dougneale@gmail.com");
    }

    public void testGetId() throws Exception {
        assertEquals(1, u.getId());
    }

    public void testGetPassword() throws Exception {

        assertEquals("password", u.getPassword());
    }

    public void testGetUsername() throws Exception {
        assertEquals("doug", u.getUsername());
    }

    public void testGetEmail() throws Exception {
        assertEquals("dougneale@gmail.com", u.getEmail());
    }
}