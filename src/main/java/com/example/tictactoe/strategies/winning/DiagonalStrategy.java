package com.example.tictactoe.strategies.winning;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Symbol;

public class DiagonalStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol currentSymbol) {
        int i = 0;
        int j = 0;
        boolean isWinner = true;
        while(i < board.getSize() && j < board.getSize()) {
            if(board.getCells().get(i).get(j).getSymbol() != currentSymbol) {
                isWinner = false;
                break;
            }
            i++;
            j++;
        }

        if(isWinner) return true;

        isWinner = true;

        i = 0;
        j = board.getSize() - 1;
        while (i < board.getSize() && j >= 0) {
            if(board.getCells().get(i).get(j).getSymbol() != currentSymbol) {
                isWinner = false;
                break;
            }
            i++;
            j--;
        }
        return isWinner;
    }
}
