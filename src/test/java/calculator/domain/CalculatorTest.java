package calculator.domain;

import calculator.exception.InvalidInputException;
import calculator.exception.InvalidNumberException;
import calculator.exception.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 올바른_입력에_대해_정상적인_계산_수행() {
        List<BigDecimal> numbers = List.of(BigDecimal.ONE, BigDecimal.TEN);

        String result = calculator.sum(numbers);

        assertThat(result).isEqualTo("11");
    }

    @Test
    void 연산_결과의_정수부_길이가_10자리를_초과하는_경우_예외가_발생한다() {
        List<BigDecimal> numbers = List.of(new BigDecimal("9999999999"), new BigDecimal("1"));

        assertThatThrownBy(() -> calculator.sum(numbers))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_INTEGER_LENGTH.getMessage());
    }
}
