package com.example.androidproapi.service;
import com.example.androidproapi.dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> getAllBoards();

    BoardDto createBoard(BoardDto boardDto );
    BoardDto getBoardById(Long boardId);
    BoardDto updateBoardById(Long boardId, BoardDto boardDto);
    void deleteBoardById( Long boardId);

}
