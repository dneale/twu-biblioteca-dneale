package com.twu.biblioteca;

/**
 * Created by dmn on 3/06/15.
 */
public class User {

    private int id;
    private String password;
    private String name;
    private String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String phoneNumber;

    public User(int id, String password, String username, String email, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String showInfo()
    {
        String s = new String();
        return  "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n";
    }
}
