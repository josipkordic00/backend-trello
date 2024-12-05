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
@RequestMapping("/tasklists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    // Get tasklists by board ID
    @GetMapping("/board/{boardId}")
    public List<TaskList> getTaskListsByBoardId(@PathVariable Long boardId) {
        return taskListService.getTaskListsByBoardId(boardId);
    }

    // Create a new tasklist under a board
    @PostMapping("/board")
    public ResponseEntity<ApiResponse> createTaskList(@RequestBody TaskList taskList) {
        int result = taskListService.createTaskList(taskList);
        return ResponseUtil.buildResponse(result, "Tasklist created successfully", "Failed to create tasklist");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTaskList(@PathVariable Long id) {
        int result = taskListService.deleteTaskList(id);
        return ResponseUtil.buildResponse(result, "Tasklist deleted successfully", "Failed to delete tasklist");
    }


}
