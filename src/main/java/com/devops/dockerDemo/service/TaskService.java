package com.devops.dockerDemo.service;

import com.devops.dockerDemo.dao.TaskRepository;
import com.devops.dockerDemo.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(String title, String description, String status, LocalDate dueDate) {
        if (!status.equalsIgnoreCase("PENDING") && !status.equalsIgnoreCase("COMPLETED")) {
            throw new RuntimeException("Invalid status value. Allowed values: PENDING, COMPLETED");
        }

        Task task=new Task(title,description,status,dueDate,LocalDate.now());
        logger.info("Creating task: {}", task);
        return taskRepository.save(task);
    }

    public List<Task> getTasks(String status) {
        logger.info("Fetching tasks with status: {}", status);
        return taskRepository.findTasksByStatusSorted(status);
    }
}
