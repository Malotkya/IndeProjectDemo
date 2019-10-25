package com.alexmalotky.util;

public class NotLoggedInException extends Exception {

    public NotLoggedInException() { super(); }

    public NotLoggedInException(String msg){
        super(msg);
    }
}
