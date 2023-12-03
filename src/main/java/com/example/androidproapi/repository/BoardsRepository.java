package com.example.androidproapi.repository;

import com.example.androidproapi.entitity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardsRepository extends JpaRepository<Boards, Long> {

}