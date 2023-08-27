package com.brsauthservice.exception;

public class BRSFieldException extends RuntimeException {

    private String message;

    public BRSFieldException(String message) {
        this.message = message;
    }

}
