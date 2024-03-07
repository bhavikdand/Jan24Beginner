package machine_coding.tictactoe.strategies.bot_playing;

import javafx.util.Pair;
import machine_coding.tictactoe.models.Board;

public interface BotPlayingStrategy {

    public Pair<Integer, Integer> makeMove(Board board);
}
