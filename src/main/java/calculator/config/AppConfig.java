package calculator.config;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(inputView());
    }
}
