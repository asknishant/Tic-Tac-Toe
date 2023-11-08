package com.example.tictactoe.models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>(); // we need to initialize collections to avoid nulll pointer exception.
    private GamesStatus gameStatus;

    public void makeMove() {

    }

    public void start() {}
    private Player checkWinner() {return null;}

    private boolean checkDraw() {
        return false;
    }

}
