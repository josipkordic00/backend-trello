package com.faketrello.trelloback.mappers;

import com.faketrello.trelloback.entity.Card;
import com.faketrello.trelloback.entity.TaskList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TaskListRowMapper implements RowMapper<TaskList> {
    private JdbcTemplate jdbcTemplate;

    public TaskListRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TaskList mapRow(ResultSet rs, int rowNum) throws SQLException {
        TaskList taskList = new TaskList();
        taskList.setId(rs.getLong("id"));
        taskList.setBoardId(rs.getLong("board_id"));
        taskList.setName(rs.getString("name"));
        taskList.setPosition(rs.getInt("position"));


        String cardSql = "SELECT * FROM cards WHERE tasklist_id = ? ORDER BY position ASC";
        List<Card> cards = jdbcTemplate.query(cardSql, new CardRowMapper(), taskList.getId());
        taskList.setCards(cards);

        return taskList;
    }
}

