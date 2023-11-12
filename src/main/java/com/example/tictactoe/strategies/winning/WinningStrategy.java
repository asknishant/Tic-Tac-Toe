package com.example.tictactoe.strategies.winning;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Symbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, Symbol currentSymbol);
}
