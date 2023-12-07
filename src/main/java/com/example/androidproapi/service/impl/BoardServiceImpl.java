package com.example.androidproapi.service.impl;
import com.example.androidproapi.dto.BoardDto;
import com.example.androidproapi.entitity.Board;

import com.example.androidproapi.repository.BoardRepository;
import com.example.androidproapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;


    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository ) {
        this.boardRepository = boardRepository;
     }

    @Override
    public List<BoardDto> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(board -> mapToDto(board)).collect(Collectors.toList());
    }


    @Override
    public BoardDto createBoard( BoardDto boardDto ) {
        Board board = new Board();
        board.setBoard_name(boardDto.getBoard_name());
        board.setCategory(boardDto.getCategory());
        board.setDescription(boardDto.getDescription());
        board.setContent(boardDto.getContent());

        Board newBoard = boardRepository.save(board);

        BoardDto boardResponse = new BoardDto();
        boardResponse.setId(newBoard.getId());
        boardResponse.setBoard_name(newBoard.getBoard_name());
        boardResponse.setCategory(newBoard.getCategory());
        boardResponse.setDescription(newBoard.getDescription());
        boardResponse.setContent(newBoard.getContent());

        return boardResponse;

    }

    @Override
    public BoardDto getBoardById(Long boardId) {
        List<Board> boards = boardRepository.findAll();
        Board board = boardRepository.findById(boardId).orElseThrow();

        return mapToDto(board);
    }


    @Override
    public BoardDto updateBoardById(Long boardId, BoardDto boardDto) {

        Board board = boardRepository.findById(boardId).orElseThrow();

        BoardDto boardResponse = new BoardDto();
        boardResponse.setBoard_name(board.getBoard_name());
        boardResponse.setCategory(board.getCategory());
        boardResponse.setDescription(board.getDescription());
        boardResponse.setContent(board.getContent());


        return boardResponse;
    }

    @Override
    public void deleteBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        boardRepository.delete(board);
    }



    //Entity -> DTO
    private BoardDto mapToDto(Board board) {
        BoardDto boardDto = new BoardDto();

        boardDto.setId(board.getId());
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
