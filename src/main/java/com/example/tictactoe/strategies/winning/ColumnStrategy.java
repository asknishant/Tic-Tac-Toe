package com.example.tictactoe.strategies.winning;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Symbol;

public class ColumnStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol currentSymbol) {
        for(int j = 0; j < board.getSize(); j++) {
            boolean isWinner = true;
            for(int i = 0; i < board.getSize(); i++) {
                if(board.getCells().get(i).get(j).getSymbol() != currentSymbol) {
                    isWinner = false;
                    break;
                }
            }
            if(isWinner) return true;
        }
        return false;
    }
}
