package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public InputView() {
    }

    public String getInput() {
        System.out.println(INPUT_GUIDE_MESSAGE);
        return readLine();
    }
}
