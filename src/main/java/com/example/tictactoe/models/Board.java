package com.example.tictactoe.models;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells;

    public Board(int size) {
        this.size = size;
        this.cells = initCells(size);
    }

    private List<List<BoardCell>> initCells(int size) {
        // we can use Arrays.fill also.
        List<BoardCell> row = Collections.nCopies(size, new BoardCell());
        List<List<BoardCell>> board = Collections.nCopies(size, row);
        return board;
    }


}
