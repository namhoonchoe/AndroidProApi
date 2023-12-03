package com.example.androidproapi.service;
import com.example.androidproapi.dto.BoardDto;
import com.example.androidproapi.dto.BoardsDto;

public interface BoardsService {

    BoardsDto getBoards();
    BoardDto updateBoardById(Long id);
    BoardDto getBoardById(Long id);
    void deleteBoardById(Long id);
    BoardDto createBoard();

}
