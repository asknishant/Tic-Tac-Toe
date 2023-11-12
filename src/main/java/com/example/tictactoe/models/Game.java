package com.example.tictactoe.models;

import com.example.tictactoe.exceptions.InvalidMoveException;
import com.example.tictactoe.exceptions.InvalidPlayerException;
import com.example.tictactoe.strategies.winning.ColumnStrategy;
import com.example.tictactoe.strategies.winning.DiagonalStrategy;
import com.example.tictactoe.strategies.winning.RowStrategy;
import com.example.tictactoe.strategies.winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>(); // we need to initialize collections to avoid nulll pointer exception.
    private GamesStatus gameStatus;
    private static final int PLAYER_COUNT = 2;
    private static final GamesStatus DEFAULT_STATUS = GamesStatus.INPROGRESS;
    private int getNextPlayerIndex = 0;
    private List<WinningStrategy> strategy = List.of(new ColumnStrategy(), new RowStrategy(), new DiagonalStrategy());
    private Player winner;

    public void start() {
        // Assign a random value to nextPlayerIndex 0/1
        getNextPlayerIndex = (int) (Math.random() * players.size()); // math.random() gives values between 0 and 1
        // Set the status to IN_PROGRESS
        gameStatus = GamesStatus.INPROGRESS;
    }
    private boolean checkWinner(Symbol currentSymbol) {
        for(WinningStrategy winningStrategy : strategy) {
            if(winningStrategy.checkWinner(board, currentSymbol)) return true;
        }
        return false;
    }


    private boolean checkDraw() {
        return board.getEmptyCells().isEmpty();
    }

    public void makeMove() {
        // Get next move
        BoardCell move = getNextMove();
        // Update board
        board.update(move);
        // Check winner
        if(checkWinner(move.getSymbol())) {
            gameStatus = GamesStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }

        if(checkDraw()) {
            gameStatus = GamesStatus.DRAWN;
            return;
        }

        // update next player
        getNextPlayerIndex = (getNextPlayerIndex + 1) % players.size();
    }

    private void validateMove(BoardCell move) {
        boolean isEmpty = board.isEmpty(move.getRow(), move.getColumn());
        if(!isEmpty) throw new InvalidMoveException(move.getRow(), move.getColumn());
    }

    private BoardCell getNextMove() {
        // Get the next player
        Player player = players.get(getNextPlayerIndex);
        // get the next move
        BoardCell move = player.makeMove(board);
        // Validate move
        validateMove(move);
        return move;
    }

    public Player  getNextPlayer() {
        return players.get(getNextPlayerIndex);
    }

    public static Builder builder() {
        return new Builder();
    }

    private Game() {}

    public static class Builder {
        private Game game;
        public Builder() {
            game = new Game();
        }

        public Builder withSize(int size) { /* we are not passing board here bcz we don't want the user to create and send their board*/
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        public Game build() {
            boolean isValid = validate();
            if(!isValid) {
                throw new InvalidPlayerException();
            }
            Game newGame = new Game();
            newGame.players = game.players;
            newGame.board = game.board;
            newGame.gameStatus = DEFAULT_STATUS;

            return newGame;
        }

        private boolean validate() {
            List<Player> players = game.players;
            if(players.size() != PLAYER_COUNT) return false;

            // If symbols are unique.
            Set<Symbol> symbols = players.stream()
                     .map(player -> player.getSymbol())
                    .collect(Collectors.toSet());

            if(symbols.size() != PLAYER_COUNT) {
                return false;
            }
            return true;
        }
    }
}
