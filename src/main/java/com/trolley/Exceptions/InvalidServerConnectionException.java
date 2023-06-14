package com.trolley.Exceptions;

public class InvalidServerConnectionException extends Exception
{
    public InvalidServerConnectionException() {
    }
    
    public InvalidServerConnectionException(final String message) {
        super(message);
    }
}
