import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            while (currentNumber > 0) {
                int currentDigit = currentNumber % 10;
                if (currentDigit == 3 || currentDigit == 6 || currentDigit == 9) {
                    clapCount ++;
                }
                currentNumber /= 10;
            }
        }
        return clapCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        System.out.println(solution(number));
    }
}
