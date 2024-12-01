package com.faketrello.trelloback.mappers;

import com.faketrello.trelloback.entity.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRowMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = new Card();
        card.setId(rs.getLong("id"));
        card.setTaskListId(rs.getLong("tasklist_id"));
        card.setName(rs.getString("name"));
        card.setDescription(rs.getString("description"));
        card.setPosition(rs.getInt("position"));
        return card;
    }
}

