package com.example.androidproapi.service.impl;


import com.example.androidproapi.dto.BoardDto;
import com.example.androidproapi.entitity.Board;
import com.example.androidproapi.entitity.Boards;
import com.example.androidproapi.repository.BoardRepository;
import com.example.androidproapi.repository.BoardsRepository;
import com.example.androidproapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    private BoardsRepository boardsRepository;
    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, BoardsRepository boardsRepository) {
        this.boardRepository = boardRepository;
        this.boardsRepository = boardsRepository;
    }

    @Override
    public BoardDto createBoard(Long boardsId, BoardDto boardDto ) {
        Board board = mapToEntity(boardDto);

        /*
        * 예외처리 로직 꼭  필요함 안 그럼 에러 표시남!
        * */

        Boards boards = boardsRepository.findById(boardsId).orElseThrow();
        Board newBoard = boardRepository.save(board);
        return mapToDto(newBoard);
    }

    @Override
    public BoardDto getBoardById(Long boardsId ,Long boardId) {

        return null;
    }


    @Override
    public BoardDto updateBoardById(Long boardsId, Long boardId, BoardDto boardDto) {

        return boardDto;
    }

    @Override
    public void deleteBoardById(Long boardsId, Long boardId) {

    }



    //Entity -> DTO
    private BoardDto mapToDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoard_name(board.getBoard_name());
        boardDto.setCategory(board.getCategory());
        boardDto.setDescription(board.getDescription());
        boardDto.setContent(board.getContent());
        return boardDto;
    }

    //DTO -> Entity
    private Board mapToEntity(BoardDto boardDto) {
        Board board = new Board();
        board.setBoard_name(boardDto.getBoard_name());
        board.setCategory(boardDto.getCategory());
        board.setDescription(boardDto.getDescription());
        board.setContent(boardDto.getContent());
        return board;
    }




}
