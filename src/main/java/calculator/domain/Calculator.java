package calculator.domain;

import calculator.exception.InvalidNumberException;
import calculator.exception.Message;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculator {
    private static final int MAX_INTEGER_DIGITS = 10;
    private static final int MAX_DECIMAL_SCALE = 6;

    public Calculator() {
    }

    public String sum(List<BigDecimal> numbers) {
        BigDecimal sum = BigDecimal.ZERO;

        for(BigDecimal number : numbers) {
            sum = sum.add(number);
        }

        validateResult(sum);
        return sum.stripTrailingZeros().toPlainString();
    }

    private void validateResult(BigDecimal result) {
        String resultToString = result.stripTrailingZeros().toPlainString();
        String[] parts = resultToString.split("\\.");

        if(parts[0].length() > MAX_INTEGER_DIGITS)
            throw new InvalidNumberException(Message.INVALID_INTEGER_LENGTH);

        if(parts.length == 2 && parts[1].length() > MAX_DECIMAL_SCALE)
            throw new InvalidNumberException(Message.INVALID_DECIMAL_SCALE);
    }
}
