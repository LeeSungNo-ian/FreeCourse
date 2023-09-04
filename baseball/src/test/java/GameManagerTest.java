import org.example.GameManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @Test
    void shouldGenerateComputerNumbersWithThreeUniqueDigits() {
        List<Integer> computerNumbers = gameManager.getComputerNumbers();
        assertThat(computerNumbers).hasSize(3);
        assertThat(computerNumbers.stream().distinct().count()).isEqualTo(3);
    }

    @Test
    void shouldReturn3StrikesWhenGuessIsCorrect() {
        List<Integer> correctGuess = Arrays.asList(1, 2, 3);
        String result = gameManager.guessUserNumbers(correctGuess);
        assertThat(result).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void shouldReturnBallsAndStrikesWhenGuessIsPartiallyCorrect() {
        List<Integer> partiallyCorrectGuess = Arrays.asList(1, 3, 2);
        String result = gameManager.guessUserNumbers(partiallyCorrectGuess);
        assertThat(result).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void shouldReturnNothingWhenGuessIsCompletelyWrong() {
        List<Integer> wrongGuess = Arrays.asList(4, 5, 6);
        String result = gameManager.guessUserNumbers(wrongGuess);
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void shouldCountAttemptsCorrectly() {
        List<Integer> wrongGuess = Arrays.asList(1, 2, 3);
        gameManager.guessUserNumbers(wrongGuess);
        assertThat(gameManager.getAttempts()).isEqualTo(1);

        List<Integer> correctGuess = Arrays.asList(1, 2, 3);
        gameManager.guessUserNumbers(correctGuess);
        assertThat(gameManager.getAttempts()).isEqualTo(2);
    }
}
