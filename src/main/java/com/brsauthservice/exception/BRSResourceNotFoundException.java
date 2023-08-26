package com.brsauthservice.exception;

public class BRSResourceNotFoundException extends RuntimeException {

    private String message;

    public BRSResourceNotFoundException(String message) {
        this.message = message;
    }

}
