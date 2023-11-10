package com.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Player {
    private Symbol symbol;

    public abstract BoardCell makeMove(Board board); // why are we returning BoardCell not grid? because returning grid can also mean player can take multiple moves at the same time on the grid.

}
