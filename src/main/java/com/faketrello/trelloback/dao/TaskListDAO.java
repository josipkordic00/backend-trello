package com.faketrello.trelloback.dao;

import com.faketrello.trelloback.entity.TaskList;
import com.faketrello.trelloback.mappers.TaskListRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskListDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TaskList> getTaskListsByBoardId(Long boardId) {
        String sql = "SELECT * FROM tasklists WHERE board_id = ? ORDER BY position ASC";
        return jdbcTemplate.query(sql, new TaskListRowMapper(jdbcTemplate), boardId);
    }


    public int createTaskList(TaskList taskList) {
        String sql = "INSERT INTO tasklists (name, board_id, position) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, taskList.getName(), taskList.getBoardId(), taskList.getPosition());
    }

}


