package calculator.domain;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = Integer.MAX_VALUE;

    private final int number;

    public Number(String number) {
        int parsedNumber = parseToInt(number);
        validateNumber(parsedNumber);
        this.number = parsedNumber;
    }

    public int getNumber() {
        return number;
    }

    private int parseToInt(String number) {
        if (number == null || number.isBlank()) return 0;

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(int number) {
        validateRange(number, MIN_NUMBER, MAX_NUMBER);
    }

    private void validateRange(int number, int min, int max) {
        if (min <= number && number <= max) return;
        throw new IllegalArgumentException();
    }
}
