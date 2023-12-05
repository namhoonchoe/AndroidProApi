package com.example.androidproapi.exceptions;

public class TaskNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public TaskNotFoundException(String message) {
        super(message);
    }
}