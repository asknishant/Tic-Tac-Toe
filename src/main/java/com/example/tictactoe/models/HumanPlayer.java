package com.example.tictactoe.models;

public class HumanPlayer extends Player {
    User user;

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
    }
}
