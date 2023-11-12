package com.example.tictactoe.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int column) {
        super("Invalid Move " + row + column);
    }
}
