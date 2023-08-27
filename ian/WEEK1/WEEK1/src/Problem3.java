public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            while (currentNumber > 0) {
                if (currentNumber % 10 == 3 || currentNumber % 10 == 6 || currentNumber % 10 == 9) {
                    clapCount ++;
                }
                currentNumber /= 10;
            }
        }
        return clapCount;
    }

    public static void main(String[] args) {
    }
}
