package com.example.androidproapi.repository;

import com.example.androidproapi.entitity.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
