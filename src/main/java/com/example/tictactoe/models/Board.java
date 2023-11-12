package com.example.tictactoe.models;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initCells(size);
    }

    private List<List<BoardCell>> initCells(int size) {
        // we can use Arrays.fill also.
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }


    public boolean isEmpty(int row, int column) {
        return cells.get(row).get(column).getSymbol() == null;
    }

    public void update(BoardCell move) {
        int row = move.getRow();
        int column = move.getColumn();

        BoardCell cell = cells.get(row).get(column);
        //cell.toBuilder().row(row).column(column).symbol(move.getSymbol()); // This will create a new object of cell and java will garbage collect the old object.

        // If using setters we can do, this won't create cell object everytime. It will change the existing object(mutable)
        cell.setRow(row);
        cell.setColumn(column);
        cell.setSymbol(move.getSymbol());
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                Symbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }

    public List<BoardCell> getEmptyCells() {
        // Iterate over the cells
        // Flatten the array -> converting 2D to 1D
        // Filter out cells where symbol != null
        return cells.stream().flatMap(Collection::stream)
                .filter(boardCell -> boardCell.getSymbol() == null)
                .toList();
    }
}
