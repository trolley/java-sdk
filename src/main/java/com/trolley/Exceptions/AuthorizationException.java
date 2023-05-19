package com.trolley.Exceptions;

public class AuthorizationException extends Exception
{
    public AuthorizationException() {
    }
    
    public AuthorizationException(final String message) {
        super(message);
    }
}
