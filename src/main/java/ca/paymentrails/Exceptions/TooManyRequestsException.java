package ca.paymentrails.Exceptions;

public class TooManyRequestsException extends Exception {

    public TooManyRequestsException() {
        super();
    }

    public TooManyRequestsException(String message) {
        super(message);
    }

}
