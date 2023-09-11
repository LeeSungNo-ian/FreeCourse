package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class RandomNumberGenerator {

    public static int[] generateRandomNumbers() {
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, num));

            numbers[i] = num;
        }

        return numbers;
    }

    private static boolean contains(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }
}
