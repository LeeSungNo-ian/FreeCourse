package Week1.onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem3Test {
    @Test
    public void gameTest(){
        int number = 13;
        int result = 4;
        assertThat(Problem3.game.start(number)).isEqualTo(result);
    }

    @Test
    public void gameTest2() {
        int number = 324;
        int result = 212;
        assertThat(Problem3.game.start(number)).isEqualTo(result);
    }
}
