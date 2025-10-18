package calculator.util;

public class InputValidator {
    private static final String HEADER_PATTERN = "^//.{1}\n$";
    private static final int HEADER_LENGTH = 5;
    private static final int HEADER_DELIMITER_INDEX = 5;
    private static final int DELIMITER_LENGTH = 1;

    private InputValidator() {
    }

    public static boolean hasHeader(String input) {
        return input.startsWith("//");
    }

    public static void validateHeader(String header) {
        validateHeaderFormat(header);
        validateHeaderLength(header);
    }

    public static void validateDelimiter(String delimiter) {
        validateDelimiterLength(delimiter);
        validateNotDigitDelimiter(delimiter);
    }

    private static void validateHeaderFormat(String header) {
        if (isValidFormat(header, HEADER_PATTERN)) return;
        throw new IllegalArgumentException();
    }

    private static void validateHeaderLength(String header) {
        if (isValidLength(header, HEADER_LENGTH)) return;
        throw new IllegalArgumentException();
    }

    private static void validateDelimiterLength(String delimiter) {
        if (isValidLength(delimiter, DELIMITER_LENGTH)) return;
        throw new IllegalArgumentException();
    }

    private static void validateNotDigitDelimiter(String delimiter) {
        if (!isDigit(delimiter.charAt(0))) return;
        throw new IllegalArgumentException();
    }

    private static boolean isValidFormat(String string, String format) {
        return string.matches(format);
    }

    private static boolean isValidLength(String string, int length) {
        return string.length() == length;
    }

    private static boolean isDigit(char character) {
        return Character.isDigit(character);
    }
}
