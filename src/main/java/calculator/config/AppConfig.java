package calculator.config;

import calculator.application.CalculatorService;
import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.view.InputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public Calculator calculator() {
        return new Calculator();
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(calculator());
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(
                inputView(),
                calculatorService());
    }
}
