package Week1.onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem2Test {

    @Test
    public void decodeTest(){
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        assertThat(Problem2.Code.decode(cryptogram)).isEqualTo(result);
    }

    @Test
    public void solutionTest(){
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    public void solutionTestifNull(){
        String cryptogram = "";
        String result = "cryptogram is empty";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}
