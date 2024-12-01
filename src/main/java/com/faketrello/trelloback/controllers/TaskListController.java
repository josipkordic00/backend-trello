package com.faketrello.trelloback.controllers;

import com.faketrello.trelloback.entity.TaskList;
import com.faketrello.trelloback.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> createTaskList(@RequestBody TaskList taskList) {
        int result = taskListService.createTaskList(taskList);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "TaskList created successfully");
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to create tasklist");
            response.put("success", false);
            return ResponseEntity.status(500).body(response);
        }
    }

}
