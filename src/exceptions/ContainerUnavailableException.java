package exceptions;

public class ContainerUnavailableException extends Exception{
    public ContainerUnavailableException() {
        super("No available containers!");
    }
}
