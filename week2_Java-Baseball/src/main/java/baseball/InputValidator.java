package baseball;
import java.util.Scanner;

public class InputValidator {
    public static int[] getUserInput() {
        int[] numbers = new int[3];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("서로 다른 3자리의 숫자를 입력해주세요: ");
                String input = scanner.next();
                if (input.length() != 3) {
                    throw new IllegalArgumentException("입력한 숫자는 3자리여야 합니다.");
                }

                for (int i = 0; i < 3; i++) {
                    numbers[i] = Integer.parseInt(input.substring(i, i + 1));
                }

                if (numbers[0] == numbers[1] || numbers[0] == numbers[2] || numbers[1] == numbers[2]) {
                    throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return numbers;
    }
}
