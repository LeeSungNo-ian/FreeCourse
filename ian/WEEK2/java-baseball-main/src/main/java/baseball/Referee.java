package baseball;

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
}


