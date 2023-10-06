package baseball;

public class BaseballGameLogic {
    private int[] computerNumbers;
    private int attempts;

    public BaseballGameLogic() {
        computerNumbers = RandomNumberGenerator.generateRandomNumbers();
        attempts = 0;
    }

    public void playGame() {
        boolean gameWon = false;
        while (!gameWon) {
            int[] userNumbers = InputValidator.getUserInput();
            int[] result = checkNumbers(userNumbers);
            printResult(result);
            if (result[0] == 0 && result[1] == 3) {
                gameWon = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            attempts++;
        }
    }

    private int[] checkNumbers(int[] userNumbers) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                result[1]++;
            } else if (contains(computerNumbers, userNumbers[i])) {
                result[0]++;
            }
        }
        return result;
    }

    private boolean contains(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    private void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            StringBuilder output = new StringBuilder();
            if (result[0] > 0) {
                output.append(result[0]).append("볼 ");
            }
            if (result[1] > 0) {
                output.append(result[1]).append("스트라이크");
            }
            System.out.println(output.toString());
        }
    }
}
