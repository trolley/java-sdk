package com.trolley.Exceptions;

public class DownForMaintenanceException extends Exception
{
    public DownForMaintenanceException() {
    }
    
    public DownForMaintenanceException(final String message) {
        super(message);
    }
}
