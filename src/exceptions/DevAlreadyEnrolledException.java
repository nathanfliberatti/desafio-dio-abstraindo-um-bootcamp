package exceptions;

public class DevAlreadyEnrolledException extends RuntimeException {
    public DevAlreadyEnrolledException(String message) {
        super(message);
    }
}
