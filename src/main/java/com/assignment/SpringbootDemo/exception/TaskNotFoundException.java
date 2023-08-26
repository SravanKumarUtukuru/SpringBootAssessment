package com.assignment.SpringbootDemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String msg) {
        super(msg);
    }
}
