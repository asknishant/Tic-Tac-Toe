package com.example.tictactoe;

import com.example.tictactoe.models.*;
import com.example.tictactoe.strategies.playing.RandomPlayingStrategy;

import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    public static void main(String[] args) {
        // Ask user for input -> name, email and symbol
        HumanPlayer humanPlayer = getUserInput();
        // Ask whether he wants to play with a human or a bot
        System.out.println("Choose opponent human/bot : H/B");
        Scanner scanner = new Scanner(System.in);
        String opponent = scanner.nextLine();

        // Create a game
        Game game = createGame(humanPlayer, opponent);
        // Start a game
        game.start();
        // Iteratively call makeMove() untill game is WON or DRAWN
        while(game.getGameStatus() == GamesStatus.INPROGRESS) { //  a bot and a human both will have a different makeMove method
            Player player = game.getNextPlayer();
            System.out.println("Next Player: " +  player.getSymbol());
            game.makeMove();

            game.getBoard().printBoard();
        }

        if(game.getGameStatus() == GamesStatus.FINISHED) {
            System.out.println("Game won by by player: " + game.getWinner().getSymbol());
        }
    }

    private static Game createGame(HumanPlayer humanPlayer, String opponent) {

        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        opponent.equals("B") ?
                                BotPlayer.builder()
                                .symbol(decideOpponentSymbol(humanPlayer.getSymbol()))
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build() :
                                getUserInput()
                )
                .build();
    }

    private static Symbol decideOpponentSymbol(Symbol symbol) {
        if(symbol == Symbol.O) return Symbol.X;
        return Symbol.O;
    }

    private static HumanPlayer getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name");

        String name = scanner.nextLine();

        System.out.println("Enter Email");
        String email = scanner.nextLine();

        System.out.println("Enter Symbol");
        Symbol symbol;
        try {
            symbol = Symbol.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid symbol: Enter X or O");
            return null;
        }

        User user = new User(name, email, null);
        return new HumanPlayer(symbol, user);
    }
}
