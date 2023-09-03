package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls;

    public Balls(String ballsString) {
        List<Ball> tmp = new ArrayList<>();
        for (int i = 0; i < ballsString.length(); i++) {
            Ball ball = new Ball(i, ballsString.charAt(i));
            tmp.add(ball);
        }
        balls = tmp;
    }

    public String findBall(Ball inputBall) {
        for (Ball ball : balls) {
            if (ball.equals(inputBall)) {
                return "SameValueAndOrder";
            } else if (ball.value == inputBall.value) {
                return "SameValue";
            }
        }
        return "NotFind";
    }

    public List<Ball> findAll() {
        return balls;
    }
}
