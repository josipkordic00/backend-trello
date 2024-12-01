package com.faketrello.trelloback.controllers;

import com.faketrello.trelloback.entity.Card;
import com.faketrello.trelloback.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    // Create a new card under a tasklist
    @PostMapping("/tasklist/")
    public ResponseEntity<Map<String, Object>> createCard(@RequestBody Card card) {
        int result = cardService.createCard(card);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "Card created successfully");
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to create card");
            response.put("success", false);
            return ResponseEntity.status(500).body(response);
        }
    }

    // Update an existing card
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCard(@PathVariable Long id, @RequestBody Card card) {
        card.setId(id);
        int result = cardService.updateCard(card);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "Card created successfully");
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to create card");
            response.put("success", false);
            return ResponseEntity.status(500).body(response);
        }
    }

}
