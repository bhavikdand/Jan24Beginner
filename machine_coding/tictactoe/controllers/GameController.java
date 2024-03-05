package machine_coding.tictactoe.controllers;

import machine_coding.tictactoe.exceptions.BotCountExceededException;
import machine_coding.tictactoe.models.Game;
import machine_coding.tictactoe.models.GameStatus;
import machine_coding.tictactoe.models.Player;

import java.util.List;

public class GameController {

    public Game createGame(List<Player> players) throws BotCountExceededException {
        return Game.getBuilder()
                .setPlayer(players)
                .build();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

}
