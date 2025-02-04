package com.faketrello.trelloback.dao;

import com.faketrello.trelloback.entity.Card;
import com.faketrello.trelloback.mappers.CardRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Card> getAllCardsByTaskListId(Long taskListId){
        String sql = "SELECT * FROM cards WHERE tasklist_id = ?";
        return jdbcTemplate.query(sql, new CardRowMapper(), taskListId);
    }
}
