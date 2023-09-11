package week1;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������ ������ ��ȣ�� �Է��ϼ���: ");
        int pobi = scanner.nextInt();

        System.out.print("ũ���� ������ ��ȣ�� �Է��ϼ���: ");
        int crong = scanner.nextInt();

        scanner.close();

        int result = solution(pobi, crong);
        System.out.println(result);
    }

    public static int solution(int pobi, int crong) {
        // �Է� ����
        if (!isValidPageNumber(pobi) || !isValidPageNumber(crong)) {
            return -1;
        }

        // �ִ� ��� �� ��
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

    // ������ ��ȣ�� �����ϰ�, ������ ���ϴ��� Ȯ���ϴ� �Լ�
    public static boolean isValidPageNumber(int page) {
        return page >= 1 && page <= 400;
    }

    // �� �ڸ� ���ڸ� ���ϰų� ���Ͽ� �ִ��� ���ϴ� �Լ�
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
