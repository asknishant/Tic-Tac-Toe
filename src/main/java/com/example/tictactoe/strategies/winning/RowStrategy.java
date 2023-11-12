package com.example.tictactoe.strategies.winning;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;
import com.example.tictactoe.models.Symbol;

import java.util.List;

public class RowStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol currentSymbol) {
        for(List<BoardCell> rows : board.getCells()) {
            boolean isWinner = true;
            for(BoardCell cell : rows) {
                if(cell.getSymbol() != currentSymbol) {
                    isWinner = false;
                    break;
                }
            }
            if(isWinner) return true;
        }
        return false;
    }
}
