package calculator.application;

import calculator.domain.Calculator;
import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.util.InputParser;
import calculator.util.InputValidator;

import java.util.List;

public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String calculateFrom(String input) {
        Delimiters delimiters = extractDelimitersFrom(input);
        Numbers numbers = extractNumbers(input, delimiters);
        return calculator.sum(numbers.toBigDecimalList());
    }

    private Delimiters extractDelimitersFrom(String input) {
        boolean hasHeader = InputValidator.hasHeader(input);

        if (hasHeader) {
            String header = InputParser.getHeader(input);
            InputValidator.validateHeader(header);
            String customDelimiter = InputParser.getCustomDelimiter(header);
            return new Delimiters(customDelimiter);
        }
        return new Delimiters();
    }

    private Numbers extractNumbers(String input, Delimiters delimiters) {
        boolean hasHeader = InputValidator.hasHeader(input);

        String body = InputParser.getBody(input, hasHeader);
        InputValidator.validateBody(body, delimiters.getDelimitersByString());
        List<String> numbers = InputParser.getNumbers(body);
        return new Numbers(numbers);
    }
}
