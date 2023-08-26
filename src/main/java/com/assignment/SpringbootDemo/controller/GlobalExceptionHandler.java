package com.assignment.SpringbootDemo.controller;

import com.assignment.SpringbootDemo.entity.Task;
import com.assignment.SpringbootDemo.exception.InvalidTaskIdException;
import com.assignment.SpringbootDemo.exception.InvalidTaskTitleException;
import com.assignment.SpringbootDemo.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFoundException(TaskNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidTaskTitleException.class)
    public String handleInvalidTaskTitleException(InvalidTaskTitleException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidTaskIdException.class)
    public String handleInvalidTaskIdException(InvalidTaskIdException e){
        return e.getMessage();
    }
}
