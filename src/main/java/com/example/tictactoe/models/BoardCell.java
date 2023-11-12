package com.example.tictactoe.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter // setter mutate our object.
// @Builder(toBuilder = true) // toBuilder creates immutable object i.e each time new object gets created.
public class BoardCell {
    private int row;
    private int column;
    private Symbol symbol;

    public BoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
