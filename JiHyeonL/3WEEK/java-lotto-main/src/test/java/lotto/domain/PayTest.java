package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PayTest {
    @Test
    @DisplayName("1000으로 나누어 떨어지지 않으면 예외발생")
    void createNotDivideByUnit() {
        assertThatThrownBy(() -> new Pay(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}