package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            List<Integer> userNumbers = parseUserInput(userInput);

            if (userNumbers.size() != 3) {
                System.out.println("3자리 숫자를 입력해야 합니다.");
                continue;
            }

            String result = gameManager.guessUserNumbers(userNumbers);
            System.out.println(result);

            if (result.contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String choice = scanner.nextLine();
                if (choice.equals("2")) {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                gameManager = new GameManager();
            }
        }

        scanner.close();
    }

    private static List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char digit = userInput.charAt(i);
            if (Character.isDigit(digit)) {
                userNumbers.add(Character.getNumericValue(digit));
            }
        }
        return userNumbers;
    }
}
