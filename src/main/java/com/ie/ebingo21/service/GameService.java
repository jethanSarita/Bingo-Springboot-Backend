package com.ie.ebingo21.service;

import com.ie.ebingo21.model.Card;
import com.ie.ebingo21.model.Game;
import com.ie.ebingo21.repository.GameRepository;
import com.ie.ebingo21.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameService {
    private final GameRepository gameRepository;
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Game getGameByCode(String gameCode) {
        return gameRepository.findById(gameCode).orElse(null);
    }

    public Game getRandomGame() {
        List<Game> allGames = gameRepository.findAll();

        if (allGames.isEmpty()) {
            throw new RuntimeException("No games found in the database");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allGames.size());

        return allGames.get(randomIndex);
    }

    public void addCardToGame(Game game, Card card) {
        Game currGame = gameRepository.findById(game.getId()).orElse(null);

        if (currGame == null) {
            throw new RuntimeException("No " + game.getId() + " game found");
        }

        currGame.getCard().add(card);

        gameRepository.save(currGame);
    }

    public Game generateGame() {

        String id;
        Game game;
        do {
            id = RandomGenerator.generateRandomString(7);
            game = gameRepository.findById(id).orElse(null);
        } while (game != null);

        game = new Game(id);

        gameRepository.save(game);

        return game;
    }

    public Game pullNumber(String gameId) {

        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            throw new RuntimeException("No " + gameId + " game found");
        }

        int uniqueNum = generateUniqueNum(game);

        game.getPulledNumbers().add(uniqueNum);

        gameRepository.save(game);

        return game;
    }

    public Game getGame(String gameId) {
        return gameRepository.findById(gameId).orElse(null);
    }

    public int generateUniqueNum(Game game) {
        Random random = new Random();
        int uniqueNum;
        do {
            uniqueNum = random.nextInt(75) + 1;
        } while (game.getPulledNumbers().contains(uniqueNum));
        return uniqueNum;
    }

}
