package com.faketrello.trelloback.mappers;

import com.faketrello.trelloback.entity.Board;
import com.faketrello.trelloback.entity.TaskList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BoardRowMapper implements RowMapper<Board> {

    private JdbcTemplate jdbcTemplate;

    public BoardRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

        Board board = new Board();

        board.setId(rs.getLong("id"));
        board.setName(rs.getString("name"));

        String sql = "SELECT * FROM tasklists WHERE board_id=?";
        List<TaskList> taskLists = jdbcTemplate.query(sql, new TaskListRowMapper(jdbcTemplate), board.getId());

        board.setTasklists(taskLists);
        return board;
    }
}
