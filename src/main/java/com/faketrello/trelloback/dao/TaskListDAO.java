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

    public List<TaskList> getAllTaskListsByBoardId(Long boardId){
        String sql = "SELECT * FROM tasklists WHERE board_id=?";
        return jdbcTemplate.query(sql, new TaskListRowMapper(jdbcTemplate), boardId);
    }

    public TaskList getTaskListById(Long taskListId){
        String sql = "SELECT * FROM tasklists WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new TaskListRowMapper(jdbcTemplate), taskListId);
    }

    public int createTaskList(TaskList taskList){
        String sql = "INSERT INTO tasklists (board_id, name, position) VALUES (?,?,?)";
        return jdbcTemplate.update(sql, taskList.getBoardId(), taskList.getName(), taskList.getPosition());
    }

    public int deleteTaskList(Long taskListId){
        String sql = "DELETE FROM tasklists WHERE id=?";
        return jdbcTemplate.update(sql, taskListId);
    }
}
