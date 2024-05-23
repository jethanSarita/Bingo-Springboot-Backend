package com.ie.ebingo21.service;

import com.ie.ebingo21.model.Card;
import com.ie.ebingo21.model.Game;
import com.ie.ebingo21.repository.CardRepository;
import com.ie.ebingo21.util.CardHelper;
import com.ie.ebingo21.util.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final GameService gameService;
    private final CardHelper cardHelper;

    public CardService(CardRepository cardRepository, GameService gameService){
        this.cardRepository = cardRepository;
        this.gameService = gameService;
        cardHelper = new CardHelper();
    }

    public Card generateCard(String gameCode) {
        //initialize data

        Game game = gameService.getRandomGame();

        if (gameCode != null) {
            game = gameService.getGameByCode(gameCode);
        }

        if (game == null) {
            game = gameService.getRandomGame();
        }

        List<Integer> b = cardHelper.generateB();
        List<Integer> i = cardHelper.generateI();
        List<Integer> n = cardHelper.generateN();
        List<Integer> g = cardHelper.generateG();
        List<Integer> o = cardHelper.generateO();

        //get a non-existent id
        String id;
        Card card;
        do {
            id = RandomGenerator.generateRandomString(7);
            card = cardRepository.findById(id).orElse(null);
        } while (card != null);

        //save
        card = new Card(id, game, b, i, n, g, o);
        cardRepository.save(card);
        gameService.addCardToGame(game, card);

        return card;
    }



    public Card getCard(String cardId) {
        return cardRepository.findById(cardId).orElse(null);
    }
}
