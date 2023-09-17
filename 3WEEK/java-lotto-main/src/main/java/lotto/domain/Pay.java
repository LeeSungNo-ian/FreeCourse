package lotto.domain;

import lotto.exception.Exception;

/**
 * 구매 가격 엔티티.
 */
public class Pay {
    private final int cost;

    public Pay(int cost) {
        validate(cost);
        this.cost = cost;
    }

    private void validate(int cost) {
        Exception exception = new Exception();
        exception.isCostValid(cost);
    }

    public int getCost() {
        return cost;
    }

}
