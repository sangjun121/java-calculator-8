package calculator.view;

public class OutputView {
    public static final String OUTPUT_GUIDE_MESSAGE = "결과 : ";

    public OutputView() {
    }

    public void printResult(String result) {
        System.out.println(OUTPUT_GUIDE_MESSAGE + result);
    }
}
