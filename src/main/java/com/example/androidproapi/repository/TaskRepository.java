package com.example.androidproapi.repository;

import com.example.androidproapi.dto.TaskDto;
import com.example.androidproapi.entitity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByBoardId(Long boardId);
}
