package bridge.view;

import bridge.util.BridgeGameMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public void gameStart() {
        System.out.println(BridgeGameMessage.GAME_START.getMessage());
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(BridgeGameMessage.INPUT_BRIDGE_SIZE.getMessage());
        return getUserInput();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readDirection() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
