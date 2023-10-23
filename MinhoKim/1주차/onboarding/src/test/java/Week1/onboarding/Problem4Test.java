package Week1.onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem4Test {
    @Test
    public void isLowerCaseTest(){
        boolean result = true;
        assertThat(Problem4.Converter.isLowerCase('a')).isEqualTo(result);
    }

    @Test
    public void isUpperCaseTest(){
        boolean result = true;
        assertThat(Problem4.Converter.isUpperCase('A')).isEqualTo(result);
    }

    @Test
    public void convertTest(){
        String word = "abcz";
        String result = "zyxa";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}
