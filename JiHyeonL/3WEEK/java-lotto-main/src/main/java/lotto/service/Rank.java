package lotto.service;

public enum Rank {
    // 순위 별 당첨금
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);
    private int value;

    Rank(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
