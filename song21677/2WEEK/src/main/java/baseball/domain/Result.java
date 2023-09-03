package baseball.domain;

public class Result {
    public int strikeNum;
    public int ballNum;

    public Result(int strikeNumValue, int ballNumValue) {
        strikeNum = strikeNumValue;
        ballNum = ballNumValue;
    }

    @Override
    public String toString() {
        if (ballNum != 0 && strikeNum != 0) {
            return ballNum + "볼 " + strikeNum + "스트라이크";
        } else if (ballNum != 0) {
            return ballNum + "볼";
        } else if (strikeNum != 0) {
            return strikeNum + "스트라이크";
        }
        return "낫싱";
    }
}
