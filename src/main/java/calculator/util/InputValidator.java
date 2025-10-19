package calculator.util;

import calculator.exception.InvalidInputException;
import calculator.exception.Message;

import java.util.List;

public class InputValidator {
    private static final String DIGIT_PATTERN = "^[0-9]+$";
    private static final String DOT = ".";
    private static final int HEADER_LENGTH = 5;

    private InputValidator() {
    }

    /**
     * Input 문자열 검증 로직
     */
    public static boolean hasHeader(String input) {
        return input.startsWith("//");
    }

    public static void validateHeader(String header) {
        validateHeaderFormat(header);
        validateHeaderLength(header);
    }

    public static void validateBody(String body, List<String> delimiters) {
        for (int index = 0; index < body.length(); index++) {
            validateBodyToken(body.substring(index, index + 1), delimiters);
        }
    }

    /**
     * public 유틸 메소드
     */
    public static boolean isValidFormat(String string, String format) {
        return string.matches(format);
    }

    public static boolean isValidLength(String string, int length) {
        return string.length() == length;
    }

    public static boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    /**
     * private 메소드
     */
    private static void validateHeaderFormat(String header) {
        if (header.startsWith("//") && header.endsWith("\\n")) return;
        throw new InvalidInputException(Message.INVALID_HEADER_FORMAT);
    }

    private static void validateHeaderLength(String header) {
        if (isValidLength(header, HEADER_LENGTH)) return;
        throw new InvalidInputException(Message.INVALID_HEADER_LENGTH);
    }

    private static void validateBodyToken(String token, List<String> delimiters) {
        if (delimiters.contains(token)) return;
        if (token.equals(DOT)) return;
        if (isValidFormat(token, DIGIT_PATTERN)) return;
        throw new InvalidInputException(Message.INVALID_TOKEN);
    }
}
