package com.example.tictactoe.models;

import com.example.tictactoe.strategies.playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder // if we use @Builder then we will not be able to use symbol() as symbol attribute is present in the Parent of BotPlayer.
public class BotPlayer extends Player {
    private GameLevel level;
    private PlayingStrategy playingStrategy; // adding our strategies on our context class. private RandomPlayingStrategy randomPlayingStrategy;
    // writing like this here is wrong. because its violating dependency inversion(high level classes should depend on other high level only not low level (loose coupling always))

    public BotPlayer(Symbol symbol, GameLevel level, PlayingStrategy playingStrategy) { // we can also use @AllArgsConstructor
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makeMove(Board board) {
        // now here goes the strategy pattern
        BoardCell boardCell = playingStrategy.makeMove(board);
        boardCell.setSymbol(getSymbol());
        return boardCell;
    }
}
