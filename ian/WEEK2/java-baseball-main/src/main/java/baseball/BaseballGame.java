package baseball;

import java.util.Set;
import static utils.PlayerInputUtil.perceiveBallNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private Computer computer = new Computer();
    private Player player = new Player();
    private Referee referee = new Referee();

    private Set<Integer> playerBalls;
    private Set<Integer> computerBalls;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        computer.throwThreeUniqueBalls();
        computerBalls = computer.getComputerNumber();

        System.out.print("숫자를 입력해주세요 : ");

        player.throwThreeUniqueBalls(perceiveBallNumber());
        playerBalls = player.getPlayerNumber();

        String gameResult = referee.judgeValue(computerBalls, playerBalls);
        System.out.println(gameResult);
    }
}

