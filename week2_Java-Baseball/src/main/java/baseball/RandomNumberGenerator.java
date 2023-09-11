package baseball;
import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    public static int[] generateRandomNumbers() {
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = random.nextInt(9) + 1;
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
