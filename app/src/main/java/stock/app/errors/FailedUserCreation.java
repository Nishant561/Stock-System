package stock.app.errors;

public class FailedUserCreation extends RuntimeException {
    public FailedUserCreation(String message, Throwable cause) {
        super(message, cause);
    }
}
