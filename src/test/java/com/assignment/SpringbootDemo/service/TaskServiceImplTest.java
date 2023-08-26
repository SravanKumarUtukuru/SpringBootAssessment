package com.assignment.SpringbootDemo.service;


import com.assignment.SpringbootDemo.dao.ITaskDao;
import com.assignment.SpringbootDemo.entity.Task;
import com.assignment.SpringbootDemo.exception.InvalidTaskIdException;
import com.assignment.SpringbootDemo.service.ITaskService;
import com.assignment.SpringbootDemo.service.TaskServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {

    @InjectMocks
    TaskServiceImpl service;

    @Mock
    ITaskDao dao;

    @Test
    void testAddTask(){
        Task returnedTask = new Task(1l,"title", "desc", true);
        lenient().when(dao.save(getTask())).thenReturn(returnedTask);
        returnedTask = service.addTask(getTask());
        Assertions.assertEquals(returnedTask.getTitle(), getTask().getTitle());
    }

    @Test
    void testGetTaskbyId(){
        Task task = getTask();
        Task returnedTask = new Task(1l,"title", "desc", true);
        lenient().when(dao.findById(1l)).thenReturn(Optional.of(returnedTask));
        service.getTaskById(1l);
        Assertions.assertEquals(task.getId(),returnedTask.getId());
    }


    @Test
    void testGetTaskbyIdWithException(){
        Assertions.assertThrows(InvalidTaskIdException.class, () -> service.getTaskById(-1l));
    }
    private Task getTask(){
        Task task = new Task(1l,"title", "desc", false);
        return task;
    }
}
