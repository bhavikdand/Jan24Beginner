package machine_coding.tictactoe.exceptions;

public class InvalidGameStateException extends RuntimeException {
    public InvalidGameStateException(String s) {
        super(s);
    }
}
