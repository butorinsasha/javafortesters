package com.javafortesters.chap013moreaboutexceptions.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
