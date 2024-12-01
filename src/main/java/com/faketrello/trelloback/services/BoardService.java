package com.faketrello.trelloback.services;

import com.faketrello.trelloback.dao.BoardDAO;
import com.faketrello.trelloback.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDAO boardDAO;


    public List<Board> getAllBoards() {
        return boardDAO.getAllBoards();
    }


    public Board getBoardById(Long id) {
        return boardDAO.getBoardById(id);
    }

    @Transactional
    public int createBoard(Board board) {
        return boardDAO.createBoard(board);
    }

}

