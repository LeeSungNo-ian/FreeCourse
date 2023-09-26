package baseball;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
    static Set<Integer> playerBall = new LinkedHashSet<>();
    public void throwThreeUniqueBalls(String balls) {
        initPlayerBall();
        for (int ballIndex = 0; ballIndex < balls.length(); ballIndex++) {
            int uniqueNumber = balls.charAt(ballIndex) - '0';
            playerBall.add(uniqueNumber);
        }
    }

    private void initPlayerBall() {
        playerBall.clear();
    }

    public Set<Integer> getPlayerNumber() {
        return playerBall;
    }
}
