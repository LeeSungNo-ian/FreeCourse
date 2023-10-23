package Week1.onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem5Test {
    @Test
    public void calculateTest(){
        assertThat(Problem5.Converter.calculate(10000, 1000)).isEqualTo(10);
    }

    @Test
    public void convertTest(){
        int money = 50237;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(Problem5.Converter.convert(money)).isEqualTo(result);
    }

    @Test
    public void solutionTest(){
        int money = 15000;
        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
}
