package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    static Set<Integer> computerBall = new LinkedHashSet<>();

    public static void throwThreeUniqueBalls() {
        initComputerBall();
        while (computerBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBall.contains(randomNumber)) {
                computerBall.add(randomNumber);
            }
        }
    }

    private static void initComputerBall() {
        computerBall.clear();
    }

    public Set<Integer> getComputerNumber() {
        return computerBall;
    }
}
