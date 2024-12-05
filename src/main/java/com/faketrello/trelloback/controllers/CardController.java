package com.faketrello.trelloback.controllers;

import com.faketrello.trelloback.entity.ApiResponse;
import com.faketrello.trelloback.entity.Card;
import com.faketrello.trelloback.services.CardService;
import com.faketrello.trelloback.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    // Create a new card under a tasklist
    @PostMapping("/tasklist/")
    public ResponseEntity<ApiResponse> createCard(@RequestBody Card card) {
        int result = cardService.createCard(card);
        return ResponseUtil.buildResponse(result, "Card created successfully", "Failed to create card");
    }

    // Update an existing card
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCard(@PathVariable Long id, @RequestBody Card card) {
        card.setId(id);
        int result = cardService.updateCard(card);
        return ResponseUtil.buildResponse(result, "Card updated successfully", "Failed to update card");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCard(@PathVariable Long id) {
        int result = cardService.deleteCard(id);
        return ResponseUtil.buildResponse(result, "Card deleted successfully", "Failed to delete card");
    }

}
