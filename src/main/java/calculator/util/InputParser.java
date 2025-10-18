package calculator.util;

public class InputParser {
    private static final int HEADER_LENGTH = 5;

    private InputParser() {
    }

    public static String getHeader(String input) {
        if (input.length() < HEADER_LENGTH)
            return input;
        return input.substring(0, HEADER_LENGTH);
    }
}
