package com.example.androidproapi.exceptions;

public class CommentNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public CommentNotFoundException(String message) {
        super(message);
    }
}