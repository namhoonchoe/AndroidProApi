package com.example.androidproapi.service.impl;
import com.example.androidproapi.entitity.Board;
import com.example.androidproapi.entitity.Task;
import com.example.androidproapi.dto.TaskDto;
import com.example.androidproapi.exceptions.BoardNotFoundException;
import com.example.androidproapi.exceptions.TaskNotFoundException;
import com.example.androidproapi.repository.BoardRepository;
import com.example.androidproapi.repository.TaskRepository;
import com.example.androidproapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private BoardRepository boardRepository;


    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, BoardRepository boardRepository) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
    }
    @Override
    public List<TaskDto> getAllTasksByBoardId(Long boardId) {
        List<Task> tasks = taskRepository.findByBoardId(boardId);
        return tasks.stream().map(task -> mapToDto(task)).collect(Collectors.toList());
    }

    @Override
    public TaskDto createTask(Long boardId, TaskDto taskDto) {
        Task task = mapToEntity(taskDto);
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("Board not found with id " + boardId));

        task.setBoard(board);
        Task newReview = taskRepository.save(task);

        return mapToDto(newReview);
    }

    @Override
    public TaskDto getTaskByTaskId(Long boardId, Long taskId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("Board not found with id " + boardId));
        Task targetTask = taskRepository.findById(taskId).orElseThrow(()  -> new TaskNotFoundException("Task not found with id " + taskId));

        if(targetTask.getBoard().getId() != board.getId()) {
            throw new TaskNotFoundException("This task does not belong to a board");
        }


        return mapToDto(targetTask);
    }


    @Override
    public TaskDto updateTaskByTaskId(Long boardId, Long taskId, TaskDto taskDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("Board not found with id " + boardId));

        Task targetTask = taskRepository.findById(taskId).orElseThrow(()  -> new TaskNotFoundException("Task not found with id " + taskId));

        if(targetTask.getBoard().getId() != board.getId()) {
            throw new TaskNotFoundException("This task does not belong to a board");
        }

        targetTask.setTask_title(taskDto.getTask_title());
        targetTask.setTask_description(taskDto.getTask_description());
        targetTask.setProgress(taskDto.getProgress());
        targetTask.setStart_date(taskDto.getStart_date());
        targetTask.setDue_date(taskDto.getDue_date());

        Task updatedTask = taskRepository.save(targetTask);
        return mapToDto(updatedTask);

    }

    @Override
    public void deleteTaskByTaskId(Long boardId, Long taskId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("Board not found with id " + boardId));

        Task targetTask = taskRepository.findById(taskId).orElseThrow(()  -> new TaskNotFoundException("Task not found with id " + taskId));

        if(targetTask.getBoard().getId() != board.getId()) {
            throw new TaskNotFoundException("This task does not belong to a board");
        }

        taskRepository.delete(targetTask);
    }

    private TaskDto mapToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTask_title(task.getTask_title());
        taskDto.setTask_description(task.getTask_description());
        taskDto.setProgress(task.getProgress());
        taskDto.setStart_date(task.getStart_date());
        taskDto.setDue_date(task.getDue_date());
        return  taskDto;
    }

    private  Task mapToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTask_title(taskDto.getTask_title());
        task.setTask_description(taskDto.getTask_description());
        task.setProgress(taskDto.getProgress());
        task.setStart_date(taskDto.getStart_date());
        task.setDue_date(taskDto.getDue_date());
        return  task;
    }
}
