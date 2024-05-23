package com.ie.ebingo21.controller;

import com.ie.ebingo21.model.Card;
import com.ie.ebingo21.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping(value = "/generateCard")
    public Card generateCard() {
         return cardService.generateCard(null);
    }

    @GetMapping(value = "/generateCard/{gameCode}")
    public Card generateCardWithCode(@PathVariable String gameCode) {
        return cardService.generateCard(gameCode);
    }

    @GetMapping("/{cardId}")
    public Card getCard(@PathVariable String cardId) {
        return cardService.getCard(cardId);
    }
}
