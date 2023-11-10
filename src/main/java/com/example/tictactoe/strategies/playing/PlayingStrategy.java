package com.example.tictactoe.strategies.playing;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
