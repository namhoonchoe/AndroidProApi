package com.example.androidproapi.repository;


import com.example.androidproapi.entitity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
