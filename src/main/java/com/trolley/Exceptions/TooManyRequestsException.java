package com.trolley.Exceptions;

public class TooManyRequestsException extends Exception
{
    public TooManyRequestsException() {
    }
    
    public TooManyRequestsException(final String message) {
        super(message);
    }
}
