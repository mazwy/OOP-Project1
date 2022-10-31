package exceptions;

public class CapacityException extends Exception {
    public CapacityException() {
        super("Capacity exceeded!");
    }
}
