package com.example.androidproapi.controllers;


import com.example.androidproapi.dto.BoardDto;
import com.example.androidproapi.service.BoardService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api/")

public class BoardsController {

    private  BoardService boardService;
    @Autowired
    public BoardsController(BoardService boardService)  {
        this.boardService = boardService;
    }

    @GetMapping("boards")
    public List<BoardDto> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping("boards")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        return new ResponseEntity<>(boardService.createBoard(boardDto), HttpStatus.CREATED);
    }


    @GetMapping("boards/{id}")
    public BoardDto getBoardById(@PathVariable(value = "id") Long boardId) {
        return boardService.getBoardById(boardId);
    }

    //PUTMAPPING
    @RequestMapping(value = "boards/{id}", method = RequestMethod.PUT) //, produces = "application/json"
    public ResponseEntity<BoardDto> updateBoardById(@PathVariable(value = "id") Long boardId, @RequestBody BoardDto boardDto) {
        BoardDto updatedBoard = boardService.updateBoardById(boardId, boardDto);
        return new ResponseEntity<>(updatedBoard,   HttpStatus.OK);
    }

    @DeleteMapping("boards/{id}")
    public ResponseEntity<String> deleteBoardById(@PathVariable(value = "id") Long boardId) {
        boardService.deleteBoardById(boardId);
        return new ResponseEntity<>("Board deleted successfully", HttpStatus.OK);
    }
}
