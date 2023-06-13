package com.trolley.Exceptions;

public class InvalidStatusCodeException extends Exception
{
    public InvalidStatusCodeException() {
    }
    
    public InvalidStatusCodeException(final String message) {
        super(message);
    }
}
