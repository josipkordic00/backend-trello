package com.faketrello.trelloback.services;

import com.faketrello.trelloback.dao.TaskListDAO;
import com.faketrello.trelloback.entity.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskListService {

    @Autowired
    private TaskListDAO taskListDAO;

    public List<TaskList> getAllTaskListsByBoardId(Long boardId) {
        return taskListDAO.getAllTaskListsByBoardId(boardId);
    }

    public TaskList getTaskListById(Long taskListId) {
        return taskListDAO.getTaskListById(taskListId);
    }

    @Transactional
    public int createTaskList(TaskList taskList) {
        return taskListDAO.createTaskList(taskList);
    }

    @Transactional
    public int deleteTaskList(Long id) {
        return taskListDAO.deleteTaskList(id);
    }
}
