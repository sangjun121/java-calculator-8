package calculator.domain;

import calculator.exception.InvalidNumberException;
import calculator.exception.Message;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;

class NumberTest {

    @Test
    void 양의_정수를_저장한다() {
        String inputNumber = "10";

        Number number = new Number(inputNumber);
        BigDecimal result = number.getNumber();
        assertThat(result)
                .isEqualTo(BigDecimal.valueOf(10).setScale(6, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    void 최대_포멧인_양의_소수를_저장한다() {
        String inputNumber = "1000000000.999999";

        Number number = new Number(inputNumber);
        BigDecimal result = number.getNumber();
        assertThat(result)
                .isEqualTo(BigDecimal.valueOf(1000000000.999999).setScale(6, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    void 공백을_입력하면_0이_저장된다() {
        String inputNumber = "";

        Number number = new Number(inputNumber);
        BigDecimal result = number.getNumber();
        assertThat(result)
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void 정수_0을_입력하면_예외가_발생한다() {
        String inputNumber = "0";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.NUMBER_CANNOT_BE_ZERO.getMessage());
    }

    @Test
    void 소수_0을_입력하면_예외가_발생한다() {
        String inputNumber = "000.000";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.NUMBER_CANNOT_BE_ZERO.getMessage());
    }

    @Test
    void 양의_정수_10자리_이상을_입력하면_예외가_발생한다() {
        String inputNumber = "99999999999";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_INTEGER_LENGTH.getMessage());
    }

    @Test
    void 소수점으로_시작하는_숫자인_경우_예외가_발생한다() {
        String inputNumber = ".99";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_DECIMAL_FORMAT.getMessage());
    }

    @Test
    void 소수점으로_끝나는_숫자인_경우_예외가_발생한다() {
        String inputNumber = "99.";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_DECIMAL_FORMAT.getMessage());
    }

    @Test
    void 소수인_경우_정수부의_길이가_10자리를_초과하면_예외가_발생한다() {
        String inputNumber = "99999999999.9";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_INTEGER_LENGTH.getMessage());
    }

    @Test
    void 소수인_경우_소수부의_길이가_6자리를_초과하면_예외가_발생한다() {
        String inputNumber = "9.9999999";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_DECIMAL_SCALE.getMessage());
    }

    @Test
    void 소수점이_두개_이상인_경우_예외가_발생한다() {
        String inputNumber = "9.999.999";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void 숫자와_소수점_이외의_문자가_있는_경우_예외가_발생한다() {
        String inputNumber = "9,999";

        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage(Message.INVALID_NUMBER_FORMAT.getMessage());
    }
}
