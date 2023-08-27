package Week1.onboarding;

import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem1Test {
    @Test
    public void ValidationTest(){
        List<Integer> Player = Arrays.asList(null, 80);
        boolean result = false;
        assertThat(Problem1.validation.check(Player)).isEqualTo(result);
    }

    @Test
    public void PlayGameBattleTest(){ // Pobi 가 승리하는 경우
        List<Integer> Crong = Arrays.asList(97, 98);
        List<Integer> Pobi = Arrays.asList(197, 198);

        int result = 1;

        assertThat(Problem1.playGame.battle(Crong, Pobi)).isEqualTo(result);
    }

    @Test
    public void solutionTest(){
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int result = 1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }
}
