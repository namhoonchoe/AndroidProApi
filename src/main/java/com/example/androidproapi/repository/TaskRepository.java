package com.example.androidproapi.repository;

import com.example.androidproapi.entitity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
