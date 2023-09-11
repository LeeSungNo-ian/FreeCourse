package week1;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: ");
        int number = scanner.nextInt();

        scanner.close();

        int result = solution(number);
        System.out.println(result);
    }

    public static int solution(int number) {
        int totalClaps = 0;

        for (int i = 1; i <= number; i++) {
            int count = count369(i);
            totalClaps += count;
        }

        return totalClaps;
    }

    // 3, 6, 9의 개수를 세는 함수
    public static int count369(int num) {
        int count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
