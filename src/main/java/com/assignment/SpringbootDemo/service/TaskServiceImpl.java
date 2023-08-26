package com.assignment.SpringbootDemo.service;

import com.assignment.SpringbootDemo.dao.ITaskDao;
import com.assignment.SpringbootDemo.entity.Task;
import com.assignment.SpringbootDemo.exception.InvalidTaskIdException;
import com.assignment.SpringbootDemo.exception.InvalidTaskTitleException;
import com.assignment.SpringbootDemo.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskDao taskDao;

    @Override
    public Task addTask(Task task) {
        validateTask(task);
        Task result = new Task();
        result.setId(task.getId());
        result.setTitle(task.getTitle());
        result.setDescription(task.getDescription());
        result.setCompleted(task.getCompleted());
        return taskDao.save(result);
    }

    @Override
    public Task getTaskById(Long id) {
        validateId(id);
        Optional<Task> optional = taskDao.findById(id);
        if(!optional.isPresent()){
            throw new TaskNotFoundException("Task not found with Id : "+id);
        }
        return optional.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }

    @Override
    public String deleteTaskById(Long id) {
        validateId(id);
        taskDao.deleteById(id);
        return "Deleted task with ID : "+id;
    }

    public Task updateCompletionStatus(Long id, boolean completed){
        validateId(id);
        Task task = getTaskById(id);
        task.setCompleted(completed);
        return taskDao.save(task);
    }

    public void validateTask(Task task){
        if(task.getTitle().isEmpty() || task.getTitle()==null){
            throw new InvalidTaskTitleException("Title cannot be empty");
        }
    }

    public void validateId(Long taskId){
        if(taskId<=0){
            throw new InvalidTaskIdException("Task ID must be greater than or equal to 1");
        }
    }
}
