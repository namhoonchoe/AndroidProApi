package com.example.androidproapi.service.impl;

import com.example.androidproapi.dto.BoardDto;
import com.example.androidproapi.dto.BoardsDto;
import com.example.androidproapi.entitity.Board;
import com.example.androidproapi.entitity.Boards;
import com.example.androidproapi.repository.BoardRepository;
import com.example.androidproapi.service.BoardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardsServiceImpl implements BoardsService {
    private BoardsRepository boardsRepository;
    @Autowired
    public BoardsServiceImpl(BoardsRepository boardsRepository) {
        this.boardsRepository = boardsRepository;
    }




    @Override
    public List<BoardDto> getBoards() {
        // >>형변환 설명 필요함!

    }

}
