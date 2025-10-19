package calculator.exception;

public class InvalidDelimiterException extends IllegalArgumentException {
    public InvalidDelimiterException() {
        super(Message.INVALID_DELIMITER.getMessage());
    }

    public InvalidDelimiterException(Message errorMessage) {
        super(errorMessage.getMessage());
    }
}
