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

    // Get all boards
    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    // Get a board by ID
    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Board board = boardService.getBoardById(id);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new board
    @PostMapping
    public ResponseEntity<ApiResponse> createBoard(@RequestBody Board board) {
        int result = boardService.createBoard(board);
        return ResponseUtil.buildResponse(result, "Board created successfully", "Failed to create board");
    }
}
