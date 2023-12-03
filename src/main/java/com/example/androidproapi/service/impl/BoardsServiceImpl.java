package com.example.androidproapi.service.impl;

import com.example.androidproapi.repository.BoardsRepository;
import com.example.androidproapi.service.BoardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardsServiceImpl implements BoardsService {
    private BoardsRepository boardsRepository;
    @Autowired
    public BoardsServiceImpl(BoardsRepository boardsRepository) {
        this.boardsRepository = boardsRepository;
    }
}
