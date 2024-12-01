package com.faketrello.trelloback.controllers;

import com.faketrello.trelloback.entity.Board;
import com.faketrello.trelloback.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> createBoard(@RequestBody Board board) {
        int result = boardService.createBoard(board);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "Board created successfully");
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to create board");
            response.put("success", false);
            return ResponseEntity.status(500).body(response);
        }
    }
}
