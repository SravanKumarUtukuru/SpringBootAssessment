package com.assignment.SpringbootDemo.controller;

import com.assignment.SpringbootDemo.entity.Task;
import com.assignment.SpringbootDemo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskService service;

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return new ResponseEntity<>(service.getTaskById(id),HttpStatus.OK);
    }

    @GetMapping("/allTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteTaskById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{completed}")
    public ResponseEntity<Task> updateTaskCompletionStatus(@PathVariable Long id, @PathVariable boolean completed){
        return new ResponseEntity<>(service.updateCompletionStatus(id, completed), HttpStatus.OK);
    }
}
