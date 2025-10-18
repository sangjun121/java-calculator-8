package calculator.config;

import calculator.application.CalculatorService;
import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public CalculatorService calculatorService() {
        return new CalculatorService();
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(
                inputView(),
                calculatorService());
    }
}
