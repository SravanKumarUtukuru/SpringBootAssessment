package com.assignment.SpringbootDemo.exception;

public class InvalidTaskIdException extends RuntimeException {
    public InvalidTaskIdException(String msg) {
        super(msg);
    }
}
