package com.trolley.Exceptions;

/**
 * <p>TooManyRequestsException class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class TooManyRequestsException extends Exception {

    /**
     * <p>Constructor for TooManyRequestsException.</p>
     */
    public TooManyRequestsException() {
        super();
    }

    /**
     * <p>Constructor for TooManyRequestsException.</p>
     *
     * @param message a {@link java.lang.String} object.
     */
    public TooManyRequestsException(String message) {
        super(message);
    }

}
