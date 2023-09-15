package lotto.domain;

import java.util.List;

/**
 * 당첨 번호 엔티티.
 * 참고) domain은 setter 사용 x
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
