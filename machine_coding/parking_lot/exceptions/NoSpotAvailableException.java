package machine_coding.parking_lot.exceptions;

public class NoSpotAvailableException extends Exception{
    public NoSpotAvailableException(String message) {
        super(message);
    }
}
