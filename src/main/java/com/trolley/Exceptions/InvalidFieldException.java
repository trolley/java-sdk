
package com.trolley.Exceptions;

public class InvalidFieldException extends Exception
{
    public InvalidFieldException() {
    }
    
    public InvalidFieldException(final String message) {
        super(message);
    }
}
