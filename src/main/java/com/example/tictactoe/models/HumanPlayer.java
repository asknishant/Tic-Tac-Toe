package com.example.tictactoe.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends Player {
    private User user;
    // @Builder.Default //  we don't want to make a builder for this attribute


    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column ");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new BoardCell(row, col, getSymbol());
    }
}
