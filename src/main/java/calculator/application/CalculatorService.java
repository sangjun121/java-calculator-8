package calculator.application;

import calculator.util.InputParser;
import calculator.util.InputValidator;

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
    }

    // TODO: 반환 값 수정
    private void extractDelimitersFrom(String input) {
        boolean hasHeader = InputValidator.hasHeader(input);

        if (hasHeader) {
            String header = InputParser.getHeader(input);
            InputValidator.validateHeader(header);
        }
    }
}
