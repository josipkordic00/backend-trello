package com.faketrello.trelloback.entity;

import java.util.List;

public class TaskList {
    private Long id;
    private String name;
    private int position;
    private Long boardId;
    private List<Card> cards;

    public TaskList() {

    }

    public TaskList(Long id, String name, int position, Long boardId, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.boardId = boardId;
        this.cards = cards;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
