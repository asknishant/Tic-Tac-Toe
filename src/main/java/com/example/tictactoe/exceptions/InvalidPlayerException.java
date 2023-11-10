package com.example.tictactoe.exceptions;

public class InvalidPlayerException extends RuntimeException {
    public InvalidPlayerException() {
        super("Invalid list of players!");
    }
}
