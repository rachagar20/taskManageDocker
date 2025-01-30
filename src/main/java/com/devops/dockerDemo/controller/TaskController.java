package com.devops.dockerDemo.controller;

import com.devops.dockerDemo.model.Task;
import com.devops.dockerDemo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private  TaskService taskService;

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Map<String, Object> payload) {
        logger.info("Received request to create task: {}", payload);
        return taskService.createTask(
                (String) payload.get("title"),
                (String) payload.get("description"),
                (String) payload.get("status"),  // Status as string
                LocalDate.parse((String) payload.get("dueDate"))
        );
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(@RequestParam(required = false) String status) {

        logger.info("Fetching tasks with optional status filter: {}", status);
        return taskService.getTasks(status);
    }
}