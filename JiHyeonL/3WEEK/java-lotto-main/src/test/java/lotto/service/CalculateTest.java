package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @Test
    @DisplayName("로또 당첨번호와 발행 로또 비교해서 등수반환 - 2등(1)")
    void compareAnswerAndGeneratedLottoAndReturnRank() {
        Calculate calculate = new Calculate();
        int rank = calculate.compareLottoAndReturnRank(List.of(1,2,3,4,5,6), 7, List.of(1,2,3,4,5,7));
        assertThat(rank).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산: 62.5f")
    void calculateWinRateAndReturnString() {
        Calculate calculate = new Calculate();
        float winRate = calculate.winRateFormat(List.of(0,0,0,0,1),8000);
        assertThat(winRate).isEqualTo((5000f/8000)*100f);
    }
}