package baseball;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Referee {
    public static boolean isNothing(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        for (int playerBall: playerBalls) {
            if (computerBalls.contains(playerBall)) {
                return false;
            }
        }
        return true;
    }

    public static int countStrikeNumber(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        int strikeNumber = 0;
        for (int index = 0; index < computerBalls.size(); index++) {
            List<Integer> computerBall = new ArrayList<Integer>(computerBalls);
            List<Integer> playerBall = new ArrayList<Integer>(playerBalls);

            if (computerBall.get(index) == playerBall.get(index)) {
                strikeNumber++;
            }
        }
        return strikeNumber;
    }

    public static int countBallNumber(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        int ballNumber = 0;
        for (int index = 0; index < computerBalls.size(); index++) {
            List<Integer> computerBall = new ArrayList<Integer>(computerBalls);
            List<Integer> playerBall = new ArrayList<Integer>(playerBalls);

            if (!computerBall.contains(playerBall.get(index))) {
                continue;
            }

            if (computerBall.get(index) != playerBall.get(index)) {
                ballNumber++;
            }
        }
        return ballNumber;
    }
}
