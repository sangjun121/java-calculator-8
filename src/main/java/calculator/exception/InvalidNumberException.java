package calculator.exception;

public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super(Message.INVALID_NUMBER.getMessage());
    }

    public InvalidNumberException(Message errorMessage) {
        super(errorMessage.getMessage());
    }
}
