package calculator.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<String> rawNumbers) {
        this.numbers = toNumberList(rawNumbers);
    }

    public List<BigDecimal> toBigDecimalList() {
        List<BigDecimal> numbersByBigDecimal = new ArrayList<>();
        for (Number number : numbers) {
            numbersByBigDecimal.add(number.getNumber());
        }
        return numbersByBigDecimal;
    }

    private List<Number> toNumberList(List<String> rawNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (String rawNumber : rawNumbers) {
            numbers.add(new Number(rawNumber));
        }
        return numbers;
    }
}
