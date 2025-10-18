package calculator.util;

public class InputParser {
    private static final int HEADER_LENGTH = 5;
    private static final int HEADER_DELIMITER_INDEX = 2;

    private InputParser() {
    }

    public static String getHeader(String input) {
        if (input.length() < HEADER_LENGTH)
            return input;
        return input.substring(0, HEADER_LENGTH);
    }

    public static String getBody(String input, boolean hasHeader) {
        if (hasHeader && input.length() == HEADER_LENGTH)
            return "";
        if (hasHeader)
            return input.substring(HEADER_LENGTH);
        return input;
    }

    public static String getCustomDelimiter(String header) {
        return String.valueOf(header.charAt(HEADER_DELIMITER_INDEX));
    }
}
