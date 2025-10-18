package calculator.exception;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super(Message.INVALID_INPUT.getMessage());
    }

    public InvalidInputException(Message errorMessage) {
        super(errorMessage.getMessage());
    }
}
