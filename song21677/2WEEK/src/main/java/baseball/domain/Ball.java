package baseball.domain;

import java.util.Objects;

public class Ball {
    int order;
    char value;

    public Ball(int order, char value) {
        this.order = order;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return order == ball.order && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, value);
    }
}
