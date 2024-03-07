package machine_coding.tictactoe.strategies.bot_playing;

import javafx.util.Pair;
import machine_coding.tictactoe.exceptions.InvalidGameStateException;
import machine_coding.tictactoe.models.Board;
import machine_coding.tictactoe.models.Cell;
import machine_coding.tictactoe.models.CellStatus;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Pair<Integer, Integer> makeMove(Board board) {
        for (List<Cell> row : board.getCells()) {
            for (Cell cell : row) {
                if(cell.getCellStatus().equals(CellStatus.UNOCCUPIED)){
                    return new Pair<>(cell.getRow(), cell.getCol());
                }
            }
        }

        throw new InvalidGameStateException("No place for bot to make a move");
    }
}
