package calculator.controller;


import calculator.application.CalculatorService;
import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView,
                                CalculatorService calculatorService) {
        this.inputView = inputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        String input = inputView.getInput();
    }
}
