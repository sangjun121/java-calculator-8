package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<String> rawNumbers) {
        this.numbers = toNumberList(rawNumbers);
    }

    public List<Integer> toIntList() {
        List<Integer> numbersByInt = new ArrayList<>();
        for (Number number : numbers) {
            numbersByInt.add(number.getNumber());
        }
        return numbersByInt;
    }

    private List<Number> toNumberList(List<String> rawNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (String rawNumber : rawNumbers) {
            numbers.add(new Number(rawNumber));
        }
        return numbers;
    }
}
