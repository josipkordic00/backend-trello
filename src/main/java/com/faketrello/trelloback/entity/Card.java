package com.faketrello.trelloback.entity;


public class Card {
    private Long id;
    private Long taskListId;
    private String name;
    private String description;
    private Integer position;


    public Card(){

    }

    public Card(Long id, Long taskListId, String name, String description, Integer position) {
        this.id = id;
        this.taskListId = taskListId;
        this.name = name;
        this.description = description;
        this.position = position;
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

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}