package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BridgeSizeTest {
    @Test
    void 입력값이_3미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BridgeSize("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BridgeSize("1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_20초과면_예외가_발생한다() {
        assertThatThrownBy(() -> new BridgeSize("21")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BridgeSize("1111111111111111111111111111111111111111111111111111"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}