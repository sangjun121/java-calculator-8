package calculator.domain;

import calculator.exception.InvalidNumberException;
import calculator.exception.Message;
import calculator.util.InputValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Number {
    private static final int MAX_INTEGER_DIGITS = 10;
    private static final int MAX_DECIMAL_SCALE = 6;
    private static final int MIN_PART_LENGTH = 1;
    private static final String ZERO = "0";

    private final BigDecimal number;

    public Number(String number) {
        validateNumber(number);
        this.number = parseToBigDecimal(number);
    }

    public BigDecimal getNumber() {
        return number;
    }

    private BigDecimal parseToBigDecimal(String number) {
        if (number == null || number.isBlank()) return BigDecimal.ZERO;

        try {
            return new BigDecimal(number).setScale(MAX_DECIMAL_SCALE, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(Message.INVALID_NUMBER_FORMAT);
        }
    }

    private void validateNumber(String number) {
        if (InputValidator.isNullOrBlank(number)) return;

        if (InputValidator.hasNotDot(number)) {
            validateIntegerPartLength(number);
            validateIntegerNotZero(number);
            return;
        }

        if (InputValidator.hasSingleDot(number)) {
            String[] parts = number.split("\\.");

            validateDecimalFormat(parts);
            validateIntegerPartLength(parts[0]);
            validateDecimalPartLength(parts[1]);
            validateDecimalNotZero(parts);
            return;
        }

        throw new InvalidNumberException(Message.INVALID_NUMBER_FORMAT);
    }

    private void validateIntegerPartLength(String integerPart) {
        if (!InputValidator.isValidLengthRange(integerPart, MIN_PART_LENGTH, MAX_INTEGER_DIGITS))
            throw new InvalidNumberException(Message.INVALID_INTEGER_LENGTH);
    }

    private void validateDecimalPartLength(String decimalPart) {
        if (!InputValidator.isValidLengthRange(decimalPart, MIN_PART_LENGTH, MAX_DECIMAL_SCALE))
            throw new InvalidNumberException(Message.INVALID_DECIMAL_SCALE);
    }

    private void validateIntegerNotZero(String number) {
        if (number.equals(ZERO))
            throw new InvalidNumberException(Message.NUMBER_CANNOT_BE_ZERO);
    }

    private void validateDecimalNotZero(String[] parts) {
        if (InputValidator.isAllZero(parts[0]) && InputValidator.isAllZero(parts[1]))
            throw new InvalidNumberException(Message.NUMBER_CANNOT_BE_ZERO);
    }

    private void validateDecimalFormat(String[] parts) {
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty())
            throw new InvalidNumberException(Message.INVALID_DECIMAL_FORMAT);
    }
}
