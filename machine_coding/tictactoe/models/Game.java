package machine_coding.tictactoe.models;

import javafx.util.Pair;
import machine_coding.tictactoe.exceptions.BotCountExceededException;
import machine_coding.tictactoe.exceptions.InvalidGameStateException;
import machine_coding.tictactoe.strategies.check_for_win.OrderOneWinningStrategy;
import machine_coding.tictactoe.strategies.check_for_win.PlayerWonStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;

    private List<Player> players;
    private GameStatus gameStatus;
    private int currentPlayerIdx;
    private List<Move> moves;
    private PlayerWonStrategy winningStrategy;

    private Game(Board board, List<Player> players, GameStatus gameStatus, int currentPlayerIdx, List<Move> moves, PlayerWonStrategy winningStrategy, int undoLimitPerPlayer) {
        this.board = board;
        this.players = players;
        this.gameStatus = gameStatus;
        this.currentPlayerIdx = currentPlayerIdx;
        this.moves = moves;
        this.winningStrategy = winningStrategy;
        for(Player player: players){
            if(player instanceof HumanPlayer){
                HumanPlayer humanPlayer = (HumanPlayer) player;
                humanPlayer.setPendingUndoCount(undoLimitPerPlayer);
            }
        }
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
        Pair<Integer, Integer> rowCol = player.makeMove(board);
        while(!this.board.checkIfCellIsUnoccupied(rowCol.getKey(), rowCol.getValue())){
            if(player instanceof HumanPlayer){
                System.out.println("Please make a move on a different cell");
            }
            rowCol = player.makeMove(this.board);
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

    public void undo(){
        int prevPlayerIdx = currentPlayerIdx - 1;
        if(prevPlayerIdx < 0) prevPlayerIdx = players.size() - 1;
        Player player = this.players.get(prevPlayerIdx);
        if(player instanceof HumanPlayer){
            Scanner scanner = new Scanner(System.in);
            HumanPlayer humanPlayer = (HumanPlayer) player;
            if(humanPlayer.getPendingUndoCount() > 0) {
                System.out.println("Do you want to undo? (y/n)");
                String input = scanner.next();
                if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                    Move move = moves.remove(moves.size() - 1);
                    Cell cell = move.getCell();
                    cell.removePlayer();
                    this.currentPlayerIdx = prevPlayerIdx;
                    winningStrategy.handleUndo(move);
                    System.out.println("We have successfully undoed player: " + player.getName() + "'s last move");
                    humanPlayer.decrementUndoCount();
                    if(humanPlayer.getPendingUndoCount() == 0){
                        System.out.println("This was your last undo, no more undo attempts left");
                    }
                }
            }
        } else {
            //do nothing, its a bot, bot cannot undo
        }
    }

    public void replay() throws InvalidGameStateException {
        if(gameStatus == GameStatus.IN_PROGRESS){
            throw new InvalidGameStateException("Game is still in progress");
        }
        board.resetBoard();
        int count = 1;
        for(Move move: moves){
            Cell cell = move.getCell();
            Player player = move.getPlayer();
            board.setPlayer(cell.getRow(), cell.getCol(), player);
            System.out.println("Turn #" + count++ + ", player " + player.getName() + " makes a move");
            printBoard();
        }
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
        private int undoLimitPerPlayer;

        public GameBuilder setPlayer(List<Player> players){
            this.players = players;
            int n = players.size();
            this.board = new Board(n+1);
            return this;
        }

        public GameBuilder setUndoLimit(int undoLimit){
            this.undoLimitPerPlayer = undoLimit;
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
            return new Game(this.board, this.players, GameStatus.IN_PROGRESS, 0, new ArrayList<>(), new OrderOneWinningStrategy(board.getSize()), this.undoLimitPerPlayer);
        }


    }
}
