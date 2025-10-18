package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    private final List<Delimiter> delimiters;

    public Delimiters() {
        this.delimiters = createDelimiters();
    }

    public Delimiters(String customDelimiter) {
        this.delimiters = createDelimiters(customDelimiter);
    }

    private List<Delimiter> createDelimiters() {
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(new Delimiter(COMMA));
        delimiters.add(new Delimiter(COLON));
        return delimiters;
    }

    private List<Delimiter> createDelimiters(String customDelimiter) {
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(new Delimiter(COMMA));
        delimiters.add(new Delimiter(COLON));
        delimiters.add(new Delimiter(customDelimiter));
        return delimiters;
    }
}
