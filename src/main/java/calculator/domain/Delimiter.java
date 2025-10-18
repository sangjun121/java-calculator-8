package calculator.domain;

import calculator.util.InputValidator;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String delimiter) {
        InputValidator.validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
