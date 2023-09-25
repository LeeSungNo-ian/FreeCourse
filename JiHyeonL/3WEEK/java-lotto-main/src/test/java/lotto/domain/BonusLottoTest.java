package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusLottoTest {

    @Test
    @DisplayName("보너스 번호가 1보다 작으면 예외 발생")
    void validBonusOverOneLotto() {
        assertThatThrownBy(() -> new BonusLotto(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 45보다 크면 예외 발생")
    void validBonusUnderFourtyFiveLotto() {
        assertThatThrownBy(() -> new BonusLotto(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

}