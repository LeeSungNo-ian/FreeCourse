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

    public static final int GAME_ONGOING = 0;
    public static final int CONTINUE_GAME = 1;
    public static final int FINISH_GAME = 2;

    int gameStatus = GAME_ONGOING;

    public void gameStart() {
        gameStatus = GAME_ONGOING;

        while (true) {
            if (isFirstRound) {
                System.out.println("숫자 야구 게임을 시작합니다.");

                computer.throwThreeUniqueBalls();
                computerBalls = computer.getComputerNumber();
                isFirstRound = false;
                System.out.println(computerBalls);
            }
            System.out.print("숫자를 입력해주세요 : ");

            player.throwThreeUniqueBalls(perceiveBallNumber());
            playerBalls = player.getPlayerNumber();

            String gameResult = referee.judgeValue(computerBalls, playerBalls);
            System.out.println(gameResult);

            if (gameResult.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n️");
                decideAdditionalGame();
            }

            if (gameStatus == FINISH_GAME) {
                break;
            }

            if (gameStatus == CONTINUE_GAME) {
                isFirstRound = true;
                gameStatus = GAME_ONGOING;
                System.out.println("게임 재시작");
            }
        }
    }

    private void decideAdditionalGame() {
        String nextGameState = gameRestartQuestion();
        if (nextGameState.equals("1")) {
            gameStatus = CONTINUE_GAME;
        }
        gameStatus = FINISH_GAME;
    }
}

