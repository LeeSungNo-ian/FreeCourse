package utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class PlayerInputUtil {
    public static void perceiveBallNumber() {
        String ballNumber = Console.readLine();
        checkAboveThreeCount(ballNumber);
        checkBelowThreeCount(ballNumber);
        checkNumberValidityAndRange(ballNumber);
        checkContainSameNumer(ballNumber);
    }

    public static void checkAboveThreeCount(String balls) {
        if (balls.length() > 3) {
            throw new IllegalArgumentException("공의 개수가 3개 보다 많아요.");
        }
    }

    public static void checkBelowThreeCount(String balls) {
        if (balls.length() < 3) {
            throw new IllegalArgumentException("공의 개수가 3개 보다 적어요.");
        }
    }

    public static void checkNumberValidityAndRange(String balls) {
        for (char ball: balls.toCharArray()) {
            if (!(ball >= '0' && ball <= '9')) {
                throw new IllegalArgumentException("숫자가 아니거나, 범위를 넘었어요.");
            }
        }
    }

    public static void checkContainSameNumer(String balls) {
        if (isCheckContainSameNumer(balls)) {
            throw new IllegalArgumentException("같은 숫자가 포함되었어요.");
        }
    }

    public static boolean isCheckContainSameNumer(String balls) {
        Set<Character> detailNumbers = new HashSet<>();
        for (char ball: balls.toCharArray()) {
            if (detailNumbers.contains(ball)) {
                return true;
            }
            detailNumbers.add(ball);
        }
        return false;
    }
}
