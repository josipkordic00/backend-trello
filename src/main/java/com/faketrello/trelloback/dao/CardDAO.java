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

    public int createCard(Card card) {
        String sql = "INSERT INTO cards (name, tasklist_id, position, description) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, card.getName(), card.getTaskListId(), card.getPosition(), card.getDescription());
    }

    public int updateCard(Card card) {
        String sql = "UPDATE cards SET description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, card.getDescription(), card.getId());
    }

    public int deleteCard(Long id) {
        String sql = "DELETE FROM cards WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


}


