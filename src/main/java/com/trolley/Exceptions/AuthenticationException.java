package com.trolley.Exceptions;

public class AuthenticationException extends Exception
{
    public AuthenticationException() {
    }
    
    public AuthenticationException(final String message) {
        super(message);
    }
}
