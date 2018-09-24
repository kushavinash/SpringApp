package com.avi.utils;

public class DemoApplicationException extends Exception
{

    public DemoApplicationException(String message) {
        super(message);
    }

    public DemoApplicationException(Exception exception) {
        super(exception);
    }

}
