package com.faketrello.trelloback.entity;

import java.util.List;

public class Board {
    private Long id;
    private String name;
    private List<TaskList> taskLists;


    public Board ()
    {}

    public Board(Long id, String name, List<TaskList> taskLists) {
        this.id = id;
        this.name = name;
        this.taskLists = taskLists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskList> taskLists) {
        this.taskLists = taskLists;
    }
}