package com.example.androidproapi.service;

import com.example.androidproapi.dto.TaskDto;

import java.util.List;

public interface TaskService {

    /*
    * Task는 Board의 자식테이블임
    * board아래에 종속되려면 기본적으로
    * boardid가 필요함!!!!
     * */

    List<TaskDto> getAllTasksByBoardId(Long boardId);
    TaskDto createTask(Long boardId, TaskDto taskDto);
    TaskDto getTaskByTaskId(Long boardId, Long taskId);
    TaskDto updateTaskByTaskId(Long boardId, Long taskId, TaskDto taskDto);

    void deleteTaskByTaskId(Long boardId, Long taskId);
}
