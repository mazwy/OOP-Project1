package Exceptions;

public class ShipCapacityException extends Exception {
    public ShipCapacityException() {
        super("Ship capacity exceeded");
    }
}
