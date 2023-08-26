package com.assignment.SpringbootDemo.exception;

public class InvalidTaskTitleException extends RuntimeException {
    public InvalidTaskTitleException(String msg) {
        super(msg);
    }
}
