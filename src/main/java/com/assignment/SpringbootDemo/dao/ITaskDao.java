package com.assignment.SpringbootDemo.dao;

import com.assignment.SpringbootDemo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskDao extends JpaRepository<Task, Long> {
}
