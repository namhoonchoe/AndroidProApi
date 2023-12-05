package com.example.androidproapi.repository;

import com.example.androidproapi.entitity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByBoardsId(Long boardsId);
}
