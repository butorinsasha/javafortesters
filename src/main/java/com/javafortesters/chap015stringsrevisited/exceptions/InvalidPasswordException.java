package com.javafortesters.chap015stringsrevisited.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
