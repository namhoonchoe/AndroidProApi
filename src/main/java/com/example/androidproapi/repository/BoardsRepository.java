package com.example.androidproapi.repository;

import com.example.androidproapi.entitity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BoardsRepository extends JpaRepository<Boards, Long> {


 }