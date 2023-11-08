package com.example.tictactoe.models;

public class BotPlayer extends Player {
    private GameLevel level;

    public BotPlayer(Symbol symbol, GameLevel level) {
        super(symbol);
        this.level = level;
    }
}
