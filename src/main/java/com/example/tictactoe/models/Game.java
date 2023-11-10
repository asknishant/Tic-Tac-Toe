package com.example.tictactoe.models;

import com.example.tictactoe.exceptions.InvalidPlayerException;
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

    public void makeMove() {}
    public void start() {}
    private Player checkWinner() {return null;}
    private boolean checkDraw() {
        return false;
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
