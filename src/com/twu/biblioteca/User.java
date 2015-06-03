package com.twu.biblioteca;

/**
 * Created by dmn on 3/06/15.
 */
public class User {

    private int id;
    private String password;
    private String username;
    private String email;

    public User(int id, String password, String username, String email) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
