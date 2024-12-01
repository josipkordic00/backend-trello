package com.faketrello.trelloback.entity;


import java.util.List;

public class TaskList {
    private Long id;
    private Long boardId;
    private String name;
    private Integer position;
    private List<Card> cards;


    public TaskList(){

    }

    public TaskList(Long id, Long boardId, String name, Integer position, List<Card> cards) {
        this.id = id;
        this.boardId = boardId;
        this.name = name;
        this.position = position;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}