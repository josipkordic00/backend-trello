package com.faketrello.trelloback.dao;

import com.faketrello.trelloback.entity.Board;
import com.faketrello.trelloback.mappers.BoardRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Board> getAllBoards(){
        String sql = "SELECT * FROM boards";
        return jdbcTemplate.query(sql, new BoardRowMapper(jdbcTemplate));
    }

    public Board getBoardById(Long boardId){
        String sql = "SELECT * FROM boards WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper(jdbcTemplate), boardId);
    }

    public int createBoard(Board board){
        String sql = "INSERT INTO boards (name) VALUES (?)";
        return jdbcTemplate.update(sql, board.getName());
    }
}
