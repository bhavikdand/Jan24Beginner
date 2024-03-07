package machine_coding.tictactoe.models;

import javafx.util.Pair;
import machine_coding.tictactoe.exceptions.BotCountExceededException;
import machine_coding.tictactoe.strategies.check_for_win.OrderOneWinningStrategy;
import machine_coding.tictactoe.strategies.check_for_win.PlayerWonStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

    private List<Player> players;
    private GameStatus gameStatus;
    private int currentPlayerIdx;
    private List<Move> moves;
    private PlayerWonStrategy winningStrategy;

    private Game(Board board, List<Player> players, GameStatus gameStatus, int currentPlayerIdx, List<Move> moves, PlayerWonStrategy winningStrategy) {
        this.board = board;
        this.players = players;
        this.gameStatus = gameStatus;
        this.currentPlayerIdx = currentPlayerIdx;
        this.moves = moves;
        this.winningStrategy = winningStrategy;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public void makeMove(){
        Player player = this.players.get(currentPlayerIdx);
        Pair<Integer, Integer> rowCol = player.makeMove();
        while(!this.board.checkIfCellIsUnoccupied(rowCol.getKey(), rowCol.getValue())){
            if(player instanceof HumanPlayer){
                System.out.println("Please make a move on a different cell");
            }
            rowCol = player.makeMove();
        }
        this.board.setPlayer(rowCol.getKey(), rowCol.getValue(), player);
        Cell cell = this.board.getCell(rowCol.getKey(), rowCol.getValue());
        Move move = new Move(player, cell);
        this.moves.add(move);

        if(winningStrategy.checkForWin(this.board, cell)){
            this.gameStatus = GameStatus.ENDED;
            return;
        } else if(checkForDraw()){
            this.gameStatus = GameStatus.DRAWN;
            return;
        }
        this.currentPlayerIdx = (this.currentPlayerIdx + 1) % (this.board.getSize() - 1);

    }

    private boolean checkForWin() {
        return false;
    }

    private boolean checkForDraw(){
        int n = this.board.getSize();
        return n * n == this.moves.size();
    }

    public Player getCurrentPlayer(){
        return this.players.get(currentPlayerIdx);
    }

    public static class GameBuilder{
        private Board board;
        private List<Player> players;
        private GameStatus gameStatus;
        private int currentPlayerIdx;
        private List<Move> moves;
        private PlayerWonStrategy winningStrategy;

        public GameBuilder setPlayer(List<Player> players){
            this.players = players;
            int n = players.size();
            this.board = new Board(n+1);
            return this;
        }

        public Game build() throws BotCountExceededException{
            int botCount = 0;
            for(Player p: players){
                if(p instanceof BotPlayer){
                    botCount++;
                }
                if(botCount > 1){
                    throw new BotCountExceededException("Found more than 1 bots, maximum only 1 bot is allowed");
                }
            }
            return new Game(this.board, this.players, GameStatus.IN_PROGRESS, 0, new ArrayList<>(), new OrderOneWinningStrategy(board.getSize()));
        }


    }
}
