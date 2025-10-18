package calculator.util;

public class InputValidator {
    private InputValidator() {
    }

    public static boolean hasHeader(String input) {
        return input.startsWith("//");
    }
}
