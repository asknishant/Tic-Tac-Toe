package com.example.tictactoe.strategies.playing;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        // Output -> A cell from the list of available cells

        // Get a list of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();
        // Generate a random index for the cells
        int randomIndex = (int)(Math.random() * emptyCells.size()); // gives index in the range of empty cells

        // Return the random cell
        BoardCell boardCell = emptyCells.get(randomIndex);
        return new BoardCell(boardCell.getRow(), boardCell.getColumn());

    }
}
