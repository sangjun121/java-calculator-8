package calculator.application;

import calculator.domain.Delimiters;
import calculator.util.InputParser;
import calculator.util.InputValidator;

import java.util.List;

public class CalculatorService {
    public CalculatorService() {
    }

    public void calculateFrom(String input) {
        /**
         * TODO: 반환 값 String으로 수정 예정
         * 1. 사용자 입력에서 구분자 추출
         * 2. 사용자 입력에서 숫자 추출
         * 3. 추출된 숫자들을 기반으로 계산하여 반환
         */
        Delimiters delimiters = extractDelimitersFrom(input);
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

    //TODO: 반환 값 수정
    private void extractNumbers(String input, Delimiters delimiters) {
        boolean hasHeader = InputValidator.hasHeader(input);

        String body = InputParser.getBody(input, hasHeader);
        InputValidator.validateBody(body, delimiters.getDelimitersByString());
        List<String> numbers = InputParser.getNumbers(body);
    }
}
