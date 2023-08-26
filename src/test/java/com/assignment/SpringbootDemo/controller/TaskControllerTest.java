package com.assignment.SpringbootDemo.controller;


import com.assignment.SpringbootDemo.entity.Task;
import com.assignment.SpringbootDemo.service.ITaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @InjectMocks
    TaskController taskController;

    @Mock
    ITaskService service;

    @Test
    void testAddTask(){
        ResponseEntity entity = taskController.addTask(new Task());
        Assertions.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

    @Test
    void testGetTaskbyId(){
        ResponseEntity entity = taskController.getTaskById(1l);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void testGetAllTaks(){
        ResponseEntity entity = taskController.getAllTasks();
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void testDeleteTasksById(){
        ResponseEntity entity = taskController.deleteTaskById(1l);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void testUpdateTask(){
        ResponseEntity entity = taskController.updateTaskCompletionStatus(1l, true);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}
