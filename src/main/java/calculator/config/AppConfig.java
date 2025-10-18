package calculator.config;

import calculator.application.CalculatorService;
import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
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
                outputView(),
                calculatorService());
    }
}
