package com.faketrello.trelloback.entity;

import java.util.List;

public class Board {

    private Long id;
    private String name;
    private List<TaskList> tasklists;

    public Board(){

    }

    public Board(Long id, String name, List<TaskList> tasklists) {
        this.id = id;
        this.name = name;
        this.tasklists = tasklists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TaskList> getTasklists() {
        return tasklists;
    }

    public void setTasklists(List<TaskList> tasklists) {
        this.tasklists = tasklists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
