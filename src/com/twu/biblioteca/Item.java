package com.twu.biblioteca;

/**
 * Created by dmn on 2/06/15.
 */
public class Item {
    protected boolean checkedOut;
    protected String title;

    public User getBorrowingUser() {
        return borrowingUser;
    }

    protected User borrowingUser;

    public Item(String title)
    {
        this.title = title;
        this.checkedOut = false;
        this.borrowingUser = null;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut(User user)  {
        this.checkedOut = true;
        borrowingUser = user;
    }

    public void checkIn() {
        this.checkedOut = false;
        borrowingUser = null;
    }
}
