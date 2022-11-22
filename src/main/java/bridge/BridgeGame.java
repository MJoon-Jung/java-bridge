package bridge;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.DrawType;
import bridge.model.GameCommand;
import bridge.model.GameMap;
import bridge.model.GameStatus;
import bridge.model.MoveResult;
import bridge.model.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Player player;
    private final GameMap gameMap;
    private GameStatus status;

    public BridgeGame(Bridge bridge, Player player, GameMap gameMap) {
        this.bridge = bridge;
        this.player = player;
        this.gameMap = gameMap;
        status = GameStatus.PLAYING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        MoveResult moveResult = player.move(bridge, direction);
        changeStatusByMoveResult(moveResult);
        gameMap.draw(moveResult);
    }

    private void changeStatusByMoveResult(MoveResult moveResult) {
        if (moveResult.compareDrawType(DrawType.FAIL)) {
            setStatus(GameStatus.FAIL);
            return;
        }
        if (player.moveToEnd(bridge)) {
            setStatus(GameStatus.COMPLETE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand command) {
        if (command == GameCommand.Q) {
            setStatus(GameStatus.FAIL_QUIT);
            return;
        }
        initialize();
    }

    private void initialize() {
        player.initialize();
        setStatus(GameStatus.PLAYING);
        gameMap.initialize();
    }

    public GameResult gameResult() {
        return new GameResult(complete(), player.getTryCount());
    }

    private void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean end() {
        return status.end();
    }

    public boolean quit() {
        return status.quit();
    }

    private boolean complete() {
        return status.complete();
    }

    public String getGameMap() {
        return gameMap.toString();
    }
}
