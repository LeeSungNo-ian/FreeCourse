package baseball;

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

	public List<Ball> getBalls() {
		return balls;
	}

	public Ball findByOrderAndValue(Ball inputBall) {
		for (Ball ball : balls) {
			if (ball.equals(inputBall)) {
				return ball;
			}
		}
		return null;
	}

	public Ball findByValue(Ball inputBall) {
		for (Ball ball : balls) {
			if (ball.getValue() == inputBall.getValue()) {
				return ball;
			}
		}
		return null;
	}
}
