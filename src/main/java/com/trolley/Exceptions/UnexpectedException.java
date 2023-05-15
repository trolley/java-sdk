package com.trolley.Exceptions;

public class UnexpectedException extends Exception
{
    public UnexpectedException() {
    }
    
    public UnexpectedException(final String message) {
        super(message);
    }
}
