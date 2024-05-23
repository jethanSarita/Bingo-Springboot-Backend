package com.ie.ebingo21.controller;

import com.ie.ebingo21.model.Game;
import com.ie.ebingo21.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/generateGame")
    public Game generateGame() {
        return gameService.generateGame();
    }

    @GetMapping("/{gameId}/pullNumber")
    public Game pullNumber(@PathVariable String gameId) {
        return gameService.pullNumber(gameId);
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }
}
