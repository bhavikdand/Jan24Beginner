package machine_coding.tictactoe.models;

import javafx.util.Pair;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private int pendingUndoCount;

    public HumanPlayer(String name,Symbol s){
        super(name, s);
    }

    @Override
    public Pair<Integer, Integer> makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Its " + this.getName() + "'s turn. Enter row and col");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Pair<>(row, col);
    }

    public int getPendingUndoCount() {
        return pendingUndoCount;
    }

    public void setPendingUndoCount(int pendingUndoCount) {
        this.pendingUndoCount = pendingUndoCount;
    }

    public void decrementUndoCount() {
        this.pendingUndoCount--;
    }
}
