package calculator.domain;

import calculator.exception.InvalidNumberException;
import calculator.exception.Message;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    private static final int MAX_INTEGER_LENGTH = 10;
    private static final int MAX_DECIMAL_LENGTH = 6;
    private static final String DOT = "\\.";
    private static final int INTEGER_PART_INDEX = 0;
    private static final int DECIMAL_PART_INDEX = 1;

    public String sum(List<BigDecimal> numbers) {
        BigDecimal result = BigDecimal.ZERO;

        for (BigDecimal number : numbers) {
            result = result.add(number);
        }

        String formattedResult = formatResult(result);
        validateResult(formattedResult);

        return formattedResult;
    }

    private String formatResult(BigDecimal result) {
        return result.stripTrailingZeros().toPlainString();
    }

    private void validateResult(String result) {
        String[] parts = result.split(DOT);

        validateIntegerPart(parts[INTEGER_PART_INDEX]);
        validateDecimalPart(parts);
    }

    private void validateIntegerPart(String integerPart) {
        if (integerPart.length() > MAX_INTEGER_LENGTH) {
            throw new InvalidNumberException(Message.INVALID_INTEGER_LENGTH);
        }
    }

    private void validateDecimalPart(String[] parts) {
        boolean hasDecimalPart = parts.length == 2;

        if (hasDecimalPart && parts[DECIMAL_PART_INDEX].length() > MAX_DECIMAL_LENGTH) {
            throw new InvalidNumberException(Message.INVALID_DECIMAL_SCALE);
        }
    }
}
