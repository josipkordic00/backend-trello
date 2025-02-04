package com.faketrello.trelloback.services;

import com.faketrello.trelloback.dao.CardDAO;
import com.faketrello.trelloback.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    public CardDAO cardDAO;

    public List<Card> getAllCardsByTaskListId(Long taskListId){
        System.out.println("getAllCardsByTaskListId");
        return cardDAO.getAllCardsByTaskListId(taskListId);
    }
}
