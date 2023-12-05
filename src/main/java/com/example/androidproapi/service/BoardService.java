package com.example.androidproapi.service;
import com.example.androidproapi.dto.BoardDto;

public interface BoardService {
    BoardDto createBoard(Long boardsId, BoardDto boardDto );
    BoardDto getBoardById(Long boardsId ,Long boardId);
    BoardDto updateBoardById(Long boardsId, Long boardId, BoardDto boardDto);
    void deleteBoardById(Long boardsId, Long boardId);

}
