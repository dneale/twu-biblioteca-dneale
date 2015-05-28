package com.twu;

/**
 * Created by dmn on 28/05/15.
 */
public class BookCheckedOutException extends Exception {
    public BookCheckedOutException() { super(); }
    public BookCheckedOutException(String message) { super(message); }
    public BookCheckedOutException(String message, Throwable cause) { super(message, cause); }
    public BookCheckedOutException(Throwable cause) { super(cause); }
}
