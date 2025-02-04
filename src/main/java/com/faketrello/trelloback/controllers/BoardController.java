package com.faketrello.trelloback.controllers;


import com.faketrello.trelloback.entity.ApiResponse;
import com.faketrello.trelloback.entity.Board;
import com.faketrello.trelloback.services.BoardService;
import com.faketrello.trelloback.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards(){
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable("id") Long id){
        return boardService.getBoardById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createBoard(@RequestBody Board board){
        int result = boardService.createBoard(board);
        return ResponseUtil.buildResponse(result, "Board created", "Failed to create board");
    }
}
