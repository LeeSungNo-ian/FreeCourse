package lotto.domain;

import lotto.exception.Exception;

/**
 * 보너스 번호 엔티티.
 */
public class BonusLotto {
    private final int number;

    public BonusLotto(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        Exception exception = new Exception();
        exception.isBonusValid(number);
    }

    public int getBonus() {
        return number;
    }

}
