package com.faketrello.trelloback.controllers;


import com.faketrello.trelloback.entity.Card;
import com.faketrello.trelloback.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/{id}")
    public List<Card> getAllCardsByTaskListId(@PathVariable("id") Long taskListId){
        return cardService.getAllCardsByTaskListId(taskListId);
    }
}
