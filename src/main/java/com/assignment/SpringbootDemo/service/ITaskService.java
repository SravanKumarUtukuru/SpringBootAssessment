package com.assignment.SpringbootDemo.service;

import com.assignment.SpringbootDemo.entity.Task;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ITaskService {

    Task addTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    String deleteTaskById(Long id);
    Task updateCompletionStatus(Long id, boolean completed);

}
