package calculator.domain;

import calculator.exception.InvalidDelimiterException;
import calculator.exception.Message;
import calculator.util.InputValidator;

public class Delimiter {
    private static final int DELIMITER_LENGTH = 1;
    private static final String DOT = ".";

    private final String delimiter;

    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    private void validateDelimiter(String delimiter) {
        validateDelimiterLength(delimiter);
        validateNotDotDelimiter(delimiter);
        validateNotDigitDelimiter(delimiter);
    }

    private void validateDelimiterLength(String delimiter) {
        if (InputValidator.isValidLength(delimiter, DELIMITER_LENGTH)) return;
        throw new InvalidDelimiterException(Message.INVALID_DELIMITER_LENGTH);
    }

    private void validateNotDotDelimiter(String delimiter) {
        if (!delimiter.equals(DOT)) return;
        throw new InvalidDelimiterException(Message.DELIMITER_CANNOT_BE_DOT);
    }

    private void validateNotDigitDelimiter(String delimiter) {
        if (!InputValidator.isDigit(delimiter.charAt(0))) return;
        throw new InvalidDelimiterException(Message.DELIMITER_CANNOT_BE_NUMBER);
    }
}
