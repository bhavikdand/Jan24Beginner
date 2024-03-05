package machine_coding.tictactoe.models;

import javafx.util.Pair;

public class BotPlayer extends Player{
    private BotLevel botLevel;

    public BotPlayer(String name, Symbol s, BotLevel level) {
        super(name, s);
        this.botLevel = level;
    }

    @Override
    public Pair<Integer, Integer> makeMove() {
        return null;
    }
}
