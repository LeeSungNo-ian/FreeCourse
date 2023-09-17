package lotto.domain;

import lotto.exception.Exception;

import java.util.List;

/**
 * 당첨 번호 엔티티.
 * 참고) domain은 setter 사용 x
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Exception exception = new Exception();
        exception.isAnswerValid(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
