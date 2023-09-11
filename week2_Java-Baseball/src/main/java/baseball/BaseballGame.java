package baseball;
import java.util.Scanner;

public class BaseballGame {
    //게임 시작
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BaseballGameLogic gameLogic = new BaseballGameLogic();
            gameLogic.playGame();

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            }
        }
    }
}

