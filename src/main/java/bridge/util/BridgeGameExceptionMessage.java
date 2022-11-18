package bridge.util;

public enum BridgeGameExceptionMessage {
    BRIDGE_SIZE_NUMBER_RANGE("다리의 길이는 3 이상 20 이하의 숫자여야 합니다."),
    RANDOM_NUMBER_NOT_MATCH("랜덤한 숫자에 해당하는 방향이 존재하지 않습니다.");

    private final String message;

    BridgeGameExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
