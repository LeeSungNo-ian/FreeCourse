package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    Balls balls;

    public Computer() {
        String ballsString = make();
        System.out.println(ballsString);
        balls = new Balls(ballsString);
    }

    // test를 위한 생성자
    public Computer(Balls inputBalls) {
        balls = inputBalls;
    }

    public String make() {
        String result = "";
        while (result.length() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);

            // 중복 검사, 중복되면 다시 랜덤뽑기
            if (result.contains(String.valueOf(random))) {
                continue;
            }

            result += random;
        }
        return result;
    }

    public String findBallStatus(Ball inputBall) {
        String result = balls.findBall(inputBall);

        if (result.equals("SameValueAndOrder")) {
            return "STRIKE";
        } else if (result.equals("SameValue")) {
            return "BALL";
        }
        return "NOTHING";
    }

    public Result calculate(Balls inputBalls) {
        int strikeNum = 0;
        int ballNum = 0;

        for (Ball ball : inputBalls.findAll()) {
            String ballStatus = findBallStatus(ball);
            if (ballStatus.equals("STRIKE")) {
                strikeNum++;
            } else if (ballStatus.equals("BALL")) {
                ballNum++;
            }
        }
        return new Result(strikeNum, ballNum);
    }
}
