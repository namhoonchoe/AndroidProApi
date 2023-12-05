package com.example.androidproapi.exceptions;

public class BoardsNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public BoardsNotFoundException(String message) {
        super(message);
    }
}
