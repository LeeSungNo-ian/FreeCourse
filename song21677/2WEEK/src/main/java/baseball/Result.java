package baseball;

public class Result {

	private int strikeNum;
	private int ballNum;

	public Result(int strikeNumValue, int ballNumValue) {
		strikeNum = strikeNumValue;
		ballNum = ballNumValue;
	}

	public int getStrikeNum() {
		return strikeNum;
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
