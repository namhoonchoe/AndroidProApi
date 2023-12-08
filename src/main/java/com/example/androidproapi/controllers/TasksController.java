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
@RequestMapping("/api/")
public class TasksController {

    private TaskService taskService;
    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("boards/{boardId}/tasks")
    public List<TaskDto> getAllTasksByBoardId(@PathVariable(value = "boardId") Long boardId) {
        return taskService.getAllTasksByBoardId(boardId);
    }
    @PostMapping("boards/{boardId}/tasks")
    public ResponseEntity<TaskDto> createTask(@PathVariable(value = "boardId") Long boardId, @RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskService.createTask(boardId, taskDto), HttpStatus.CREATED); //(taskDto, HttpStatus.CREATED)
    }
    @GetMapping("boards/{boardId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(value = "boardId") Long boardId, @PathVariable(value = "taskId") Long taskId) {
        TaskDto taskDto = taskService.getTaskByTaskId(boardId, taskId);
        return new ResponseEntity<>(taskDto, HttpStatus.OK); //(taskDto, HttpStatus.OK)
    }
    @PutMapping("boards/{boardId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> updateTaskById(@PathVariable(value = "boardId") Long boardId, @PathVariable(value = "taskId") Long taskId, @RequestBody TaskDto taskDto) {
        TaskDto updatedTask = taskService.updateTaskByTaskId(boardId, taskId, taskDto);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK); //(updatedTask, HttpStatus.OK)
    }
    @DeleteMapping("boards/{boardId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable(value = "boardId") Long boardId, @PathVariable(value = "taskId") Long taskId) {
            taskService.deleteTaskByTaskId(boardId, taskId);
        return new ResponseEntity<>("task deleted successfully", HttpStatus.OK);
    }
    }
