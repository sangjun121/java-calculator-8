package calculator.domain;

import calculator.exception.InvalidInputException;
import calculator.exception.Message;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterTest {

    @Test
    void 정상적인_구분자를_저장한다(){
        String inputDelimiter = ";";

        Delimiter delimiter = new Delimiter(inputDelimiter);
        String result = delimiter.getDelimiter();

        assertThat(result).isEqualTo(inputDelimiter);
    }

    @Test
    void 공백문자도_구분자로_지정_가능하다(){
        String inputDelimiter = " ";

        Delimiter delimiter = new Delimiter(inputDelimiter);
        String result = delimiter.getDelimiter();

        assertThat(result).isEqualTo(inputDelimiter);
    }

    @Test
    void 구분자가_한자리가_아니면_예외가_발생한다(){
        String inputDelimiter = ";;";

        assertThatThrownBy(() -> new Delimiter(inputDelimiter))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_DELIMITER_LENGTH.getMessage());
    }

    @Test
    void 구분자가_빈_문자이면_예외가_발생한다(){
        String inputDelimiter = "";

        assertThatThrownBy(() -> new Delimiter(inputDelimiter))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.INVALID_DELIMITER_LENGTH.getMessage());
    }

    @Test
    void 구분자가_숫자이면_예외가_발생한다(){
        String inputDelimiter = "9";

        assertThatThrownBy(() -> new Delimiter(inputDelimiter))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.DELIMITER_CANNOT_BE_NUMBER.getMessage());
    }

    @Test
    void 구분자가_소수점이면_예외가_발생한다(){
        String inputDelimiter = ".";

        assertThatThrownBy(() -> new Delimiter(inputDelimiter))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(Message.DELIMITER_CANNOT_BE_DOT.getMessage());
    }
}
