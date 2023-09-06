package baseball;

import utils.PlayerGameRestartUtil;

import java.util.Set;
import static utils.PlayerInputUtil.perceiveBallNumber;
import static utils.PlayerGameRestartUtil.gameRestartQuestion;

public class BaseballGame {
    private Computer computer = new Computer();
    private Player player = new Player();
    private Referee referee = new Referee();

    private Set<Integer> playerBalls;
    private Set<Integer> computerBalls;
    private boolean isFirstRound = true;

    public void gameStart() {
        while (true) {
            if (isFirstRound) {
                System.out.println("숫자 야구 게임을 시작합니다.");

                computer.throwThreeUniqueBalls();
                computerBalls = computer.getComputerNumber();
                isFirstRound = false;
            }
            System.out.print("숫자를 입력해주세요 : ");

            player.throwThreeUniqueBalls(perceiveBallNumber());
            playerBalls = player.getPlayerNumber();

            String gameResult = referee.judgeValue(computerBalls, playerBalls);
            System.out.println(gameResult);

            if (gameResult.equals("3스트라이크")) {
                System.out.println("3스트라이크 일 때 상황을 가정하는 함수입니다 :)️");
            }
        }
    }
}

