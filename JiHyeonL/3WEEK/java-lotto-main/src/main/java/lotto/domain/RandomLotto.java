package lotto.domain;

import java.util.List;

/**
 * 랜덤으로 6개 번호를 생성한 로또 하나의 엔티티
 */
public class RandomLotto {
    private final List<Integer> lotto;

    public RandomLotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getRandomLotto() {
        return lotto;
    }

    public String getRandomLottoToString() {
        return lotto.toString();
    }
}
