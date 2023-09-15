package lotto.domain;

/**
 * 보너스 번호 엔티티.
 */
public class BonusLotto {
    private final int number;

    public BonusLotto(int number) {
        this.number = number;
    }

    public int getBonus() {
        return number;
    }

}
