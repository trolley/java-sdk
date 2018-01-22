package ca.paymentrails.Exceptions;

public class AuthorizationException extends Exception {

    public AuthorizationException() {
        super();
    }

    public AuthorizationException(String message) {
        super(message);
    }

}
