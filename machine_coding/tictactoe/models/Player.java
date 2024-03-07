package machine_coding.tictactoe.models;

import javafx.util.Pair;

public abstract class Player {
    private String name;
    private Symbol symbol;

    public Player(String name, Symbol s) {
        this.name = name;
        this.symbol = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol s) {
        this.symbol = s;
    }

    public abstract Pair<Integer, Integer> makeMove(Board board);
}
