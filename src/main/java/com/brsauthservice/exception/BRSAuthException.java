package com.brsauthservice.exception;

public class BRSAuthException extends RuntimeException {

    private String message;

    public BRSAuthException(String message) {
        this.message = message;
    }

}
