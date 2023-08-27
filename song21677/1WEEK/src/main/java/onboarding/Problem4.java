package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static boolean verifySize(String word) {
        return 1 <= word.length() && word.length() <= 1000;
    }

    private static boolean verifyChar(String c) {
        return Character.isAlphabetic(c.charAt(0));
    }

}
