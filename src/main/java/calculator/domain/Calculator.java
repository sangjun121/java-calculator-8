package calculator.domain;

import java.util.List;

public class Calculator {
    public Calculator() {
    }

    public String sum(List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return String.valueOf(sum);
    }
}
