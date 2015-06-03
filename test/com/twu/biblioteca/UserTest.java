package com.twu.biblioteca;

import junit.framework.TestCase;

/**
 * Created by dmn on 3/06/15.
 */
public class UserTest extends TestCase {

    User u;

    public void setUp() throws Exception {
        super.setUp();
        u = new User(1, "password", "doug", "dougneale@gmail.com", "1234 1234");
    }

    public void testGetId() throws Exception {
        assertEquals(1, u.getId());
    }

    public void testGetPassword() throws Exception {

        assertEquals("password", u.getPassword());
    }

    public void testGetName() throws Exception {
        assertEquals("doug", u.getName());
    }

    public void testGetEmail() throws Exception {
        assertEquals("dougneale@gmail.com", u.getEmail());
    }

    public void testShowInfo() throws Exception {
        assertEquals( "ID: 1\n" +
                "Name: doug\n" +
                "Email: dougneale@gmail.com\n", u.showInfo());
    }

    public void testGetPhoneNumber() throws Exception {
        assertEquals("1234 1234", u.getPhoneNumber());
    }
}