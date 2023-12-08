package com.example.androidproapi.exceptions;

public class TaskNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 3;

    public TaskNotFoundException(String message) {
        super(message);
    }
}