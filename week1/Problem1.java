package week1;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("포비의 페이지 번호를 입력하세요: ");
        int pobi = scanner.nextInt();

        System.out.print("크롱의 페이지 번호를 입력하세요: ");
        int crong = scanner.nextInt();

        scanner.close();

        int result = solution(pobi, crong);
        System.out.println(result);
    }

    public static int solution(int pobi, int crong) {
        // 입력 검증
        if (!isValidPageNumber(pobi) || !isValidPageNumber(crong)) {
            return -1;
        }

        // 최댓값 계산 및 비교
        int pobiMaxScore = getMaxScore(pobi);
        int crongMaxScore = getMaxScore(crong);

        if (pobiMaxScore > crongMaxScore) {
            return 1;
        } else if (pobiMaxScore < crongMaxScore) {
            return 2;
        } else {
            return 0;
        }
    }

    // 페이지 번호가 존재하고, 범위에 속하는지 확인하는 함수
    public static boolean isValidPageNumber(int page) {
        return page >= 1 && page <= 400;
    }

    // 각 자리 숫자를 더하거나 곱하여 최댓값을 구하는 함수
    public static int getMaxScore(int page) {
        int[] digits = String.valueOf(page)
                           .chars()
                           .map(Character::getNumericValue)
                           .toArray();

        int sum = 0;
        int product = 1;

        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }

        return Math.max(sum, product);
    }
}
