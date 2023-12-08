package com.example.androidproapi.controllers;

import com.example.androidproapi.dto.TaskDto;
import com.example.androidproapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class TasksController {

    private TaskService taskService;
    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }
}
