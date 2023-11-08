package com.example.tictactoe;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Game;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class TicTacToeTest {
    @Test
    public void testCreateGame() {
//        Board board = new Board();
//        Game game = new Game();
    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(3);
        int rowSize = board.getCells().get(0).size();
        assertEquals("If the ctor of boardis called with n , it should create n rows", 3,rowSize);

        int columnSize = board.getCells().get(0).size();
        assertEquals("If the ctor of boardis called with n , it should create n colms", 3,columnSize);
    }
}
