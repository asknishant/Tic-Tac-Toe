package com.example.tictactoe;

import com.example.tictactoe.models.*;
import com.example.tictactoe.strategies.playing.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class TicTacToeTest {
    private static final int BOARD_SIZE = 3;
    @Test
    public void testCreateGame() {

//        Board board = new Board(BOARD_SIZE);
//        Player humanPlayer = new HumanPlayer(Symbol.X, new User());
//        Player bot = new BotPlayer(Symbol.X, GameLevel.EASY, new RandomPlayingStrategy());
//        Game game = new Game(board, List.of(humanPlayer, bot),GamesStatus.INPROGRESS);
        /*
        The above process of creating Game object if a bit complicated rather we can make it easy by using builder. So create game using builder
        If you have more than 3 constructors then use builder
        * */

        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(HumanPlayer.builder().symbol(Symbol.O).user(new User()).build())
                .withPlayer(BotPlayer.builder().symbol(Symbol.X).level(GameLevel.EASY).playingStrategy(new RandomPlayingStrategy()).build())
                .build();


        assertEquals("If the game is created it has 2 players",2, game.getPlayers().size() );
    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(BOARD_SIZE);
        int rowSize = board.getCells().get(0).size();
        assertEquals("If the ctor of boardis called with n , it should create n rows", 3,rowSize);

        int columnSize = board.getCells().get(0).size();
        assertEquals("If the ctor of boardis called with n , it should create n colms", 3,columnSize);
    }
}
