package com.afs.tdd.exceptions;

public class CommandNotDefinedException extends Exception {
    public CommandNotDefinedException(String message) {
        super(message);
    }
}