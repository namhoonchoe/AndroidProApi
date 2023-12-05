package com.example.androidproapi.exceptions;

public class BoardNotFoundException  extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public BoardNotFoundException(String message) {
        super(message);
    }
}
