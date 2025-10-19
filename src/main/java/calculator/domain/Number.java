package calculator.domain;

import calculator.exception.InvalidNumberException;
import calculator.exception.Message;

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
        if (isNullOrBlank(number)) return;

        if (hasNotDot(number)) {
            if (!isValidLength(number, MIN_PART_LENGTH, MAX_INTEGER_DIGITS))
                throw new InvalidNumberException(Message.INVALID_INTEGER_LENGTH);
            if (number.equals(ZERO))
                throw new InvalidNumberException(Message.NUMBER_CANNOT_BE_ZERO);
            return;
        }

        if (hasSingleDot(number)) {
            String[] parts = number.split("\\.");

            if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty())
                throw new InvalidNumberException(Message.INVALID_DECIMAL_FORMAT);

            if (!isValidLength(parts[0], MIN_PART_LENGTH, MAX_INTEGER_DIGITS))
                throw new InvalidNumberException(Message.INVALID_INTEGER_LENGTH);

            if (!isValidLength(parts[1], MIN_PART_LENGTH, MAX_DECIMAL_SCALE))
                throw new InvalidNumberException(Message.INVALID_DECIMAL_SCALE);

            if (parts[0].equals(ZERO) && parts[1].equals(ZERO))
                throw new InvalidNumberException(Message.NUMBER_CANNOT_BE_ZERO);

            return;
        }

        throw new InvalidNumberException(Message.INVALID_NUMBER_FORMAT);
    }

    private boolean isNullOrBlank(String number) {
        return number == null || number.isBlank();
    }

    private boolean hasNotDot(String number) {
        return !number.contains(".");
    }

    private boolean hasSingleDot(String number) {
        return number.chars()
                .filter(token -> token == '.')
                .count() == 1;
    }

    private boolean isValidLength(String number, int minLength, int maxLength) {
        return minLength <= number.length() && number.length() <= maxLength;
    }
}
