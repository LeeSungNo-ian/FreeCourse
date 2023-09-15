package lotto.domain;

/**
 * 구매 가격 엔티티.
 */
public class Pay {
    private final int cost;

    public Pay(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

}
