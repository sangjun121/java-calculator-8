package calculator.util;

public class InputValidator {
    private static final String HEADER_PATTERN = "^//.{1}\n$";
    private static final int HEADER_LENGTH = 5;
    private static final int HEADER_DELIMITER_INDEX = 5;

    private InputValidator() {
    }

    public static boolean hasHeader(String input) {
        return input.startsWith("//");
    }

    public static void validateHeader(String header) {
        validateHeaderFormat(header);
        validateHeaderLength(header);
        validateCustomDelimiter(header);
    }

    private static void validateHeaderFormat(String header) {
        if (isValidFormat(header, HEADER_PATTERN)) return;
        throw new IllegalArgumentException();
    }

    private static void validateHeaderLength(String header) {
        if (isValidLength(header, HEADER_LENGTH)) return;
        throw new IllegalArgumentException();
    }

    private static void validateCustomDelimiter(String header) {
        if (!isDigit(header, HEADER_DELIMITER_INDEX)) return;
        throw new IllegalArgumentException();
    }

    private static boolean isValidFormat(String string, String format) {
        return string.matches(format);
    }

    private static boolean isValidLength(String string, int length) {
        return string.length() == length;
    }

    private static boolean isDigit(String string, int index) {
        return Character.isDigit(string.charAt(index));
    }
}
