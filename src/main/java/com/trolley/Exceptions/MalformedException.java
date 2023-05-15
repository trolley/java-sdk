package com.trolley.Exceptions;

public class MalformedException extends Exception
{
    public MalformedException() {
    }
    
    public MalformedException(final String message) {
        super(message);
    }
}
