package com.faketrello.trelloback.controllers;

import com.faketrello.trelloback.entity.ApiResponse;
import com.faketrello.trelloback.entity.TaskList;
import com.faketrello.trelloback.services.TaskListService;
import com.faketrello.trelloback.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasklist")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping("/board/{id}")
    public List<TaskList> getAllTaskListsByBoardId(@PathVariable("id") Long boardId) {
        return taskListService.getAllTaskListsByBoardId(boardId);
    }

    @GetMapping("/{id}")
    public TaskList getTaskListById(@PathVariable("id") Long id) {
        return taskListService.getTaskListById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createTaskList(@RequestBody TaskList taskList) {
        int result = taskListService.createTaskList(taskList);
        return ResponseUtil.buildResponse(result,"Tasklist created", "Failed to create tasklist");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTaskList(@PathVariable("id") Long id) {
        int result = taskListService.deleteTaskList(id);
        return ResponseUtil.buildResponse(result,"Tasklist deleted", "Failed to delete tasklist");
    }
}
