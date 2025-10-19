package calculator.application;

import calculator.domain.Calculator;
import calculator.exception.InvalidInputException;
import calculator.exception.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService(new Calculator());
    }

    @Test
    void 커스텀_구분자가_없는_정상적인_값을_입력한다() {
        String input = "1,2:3";

        String result = calculatorService.calculateFrom(input);

        assertThat(result).isEqualTo("6");
    }

    @Test
    void 커스텀_구분자가_있는_정상적인_값을_입력한다() {
        String input = "//;\\n1;2,3";

        String result = calculatorService.calculateFrom(input);

        assertThat(result).isEqualTo("6");
    }

    @Test
    void 빈_문자_입력시_0이_반환된다() {
        String input = "";

        String result = calculatorService.calculateFrom(input);

        assertThat(result).isEqualTo("0");
    }

    @Test
    void 헤더_포멧이_슬래시_두개로_시작하지_않으면_바디로_인식하여_예외가_발생한다() {
        String input = "/;\\n1;2,3";

        assertThatThrownBy(() -> calculatorService.calculateFrom(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_TOKEN.getMessage());
    }

    @Test
    void 헤더_포멧이_슬래시_두개로_시작하지만_포멧이_올바르지_않으면_예외가_발생한다() {
        String input = "//;!n1;2,3";

        assertThatThrownBy(() -> calculatorService.calculateFrom(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_HEADER_FORMAT.getMessage());
    }

    @Test
    void 헤더_내부에_커스텀_지정자가_없으면_예외가_발생한다() {
        String input = "//\n1;2,3";

        assertThatThrownBy(() -> calculatorService.calculateFrom(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_HEADER_FORMAT.getMessage());
    }

    @Test
    void 바디_내부에_지정된_구분자_혹은_숫자가_아닌_문자가_있을시_예외가_발생한다() {
        String input = "//;\\n1;2!3";

        assertThatThrownBy(() -> calculatorService.calculateFrom(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_TOKEN.getMessage());
    }

    @Test
    void 바디_내부에_음수가_있을시_예외가_발생한다() {
        String input = "//;\\n-1;2;3";

        assertThatThrownBy(() -> calculatorService.calculateFrom(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_TOKEN.getMessage());
    }
}
