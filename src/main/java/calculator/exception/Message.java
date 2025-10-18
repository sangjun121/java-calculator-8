package calculator.exception;

public enum Message {
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_HEADER_FORMAT("올바르지 않은 헤더 포멧입니다."),
    INVALID_HEADER_LENGTH("올바르지 않은 헤더 길이입니다. 헤더 길이는 반드시 5자여야 합니다."),
    INVALID_DELIMITER_LENGTH("올바르지 않은 구분자 길이입니다. 구분자 길이는 반드시 1자여야 합니다."),
    DELIMITER_CANNOT_BE_NUMBER("구분자는 숫자일 수 없습니다."),
    DELIMITER_CANNOT_BE_DOT("구분자는 소수점(.)일 수 없습니다."),
    INVALID_TOKEN("문자열의 각 문자(토큰)은 지정된 구분자 혹은 숫자여야 합니다."),
    INVALID_NUMBER("올바르지 않은 숫자입니다."),
    INVALID_NUMBER_RANGE("올바르지 않은 숫자 범위입니다."),
    INVALID_NUMBER_FORMAT("올바르지 않은 숫자 형식입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
