package com.twu.biblioteca;

/**
 * Created by dmn on 2/06/15.
 */
public class Item {
    protected boolean checkedOut;
    protected String title;

    public Item(String title)
    {
        this.title = title;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut()  {
        this.checkedOut = true;
    }

    public void checkIn() {
        this.checkedOut = false;
    }
}
