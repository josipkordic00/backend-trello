package com.faketrello.trelloback.entity;

public class Card {
    private Long id;
    private String name;
    private String description;
    private int position;
    private Long taskListId;

    public Card(){

    }

    public Card(Long id, String name, String description, int position, Long taskListId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
        this.taskListId = taskListId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }
}
