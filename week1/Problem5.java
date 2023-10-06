package week1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("금액을 입력하세요: ");
        int money = scanner.nextInt();

        List<Integer> result = solution(money);
        System.out.println(result);

        scanner.close();
    }

    public static List<Integer> solution(int money) {
        List<Integer> denominations = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> result = new ArrayList<>();

        for (int denomination : denominations) {
            int count = money / denomination;
            result.add(count);
            money %= denomination;
        }

        return result;
    }
}
