package com.example.tictactoe.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class HumanPlayer extends Player {
    User user;

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
    }

    @Override
    public BoardCell makeMove(Board board) {
        return null;
    }
}
