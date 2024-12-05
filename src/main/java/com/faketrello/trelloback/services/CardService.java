package com.faketrello.trelloback.services;


import com.faketrello.trelloback.dao.CardDAO;
import com.faketrello.trelloback.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardDAO cardDAO;


    @Transactional
    public int createCard(Card card) {
        return cardDAO.createCard(card);
    }

    @Transactional
    public int updateCard(Card card) {
        return cardDAO.updateCard(card);
    }

    @Transactional
    public int deleteCard(Long id) {
        return cardDAO.deleteCard(id);
    }

}

