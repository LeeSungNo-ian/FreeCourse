package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<String, String> dict = new HashMap<>() {{
        put("A", "Z"); put("B", "Y"); put("C", "X");
        put("D", "W"); put("E", "V"); put("F", "U");
        put("G", "T"); put("H", "S"); put("I", "R");
        put("J", "Q"); put("K", "P"); put("L", "O");
        put("M", "N"); put("N", "M"); put("O", "L");
        put("P", "K"); put("Q", "J"); put("R", "I");
        put("S", "J"); put("T", "G"); put("U", "F");
        put("V", "E"); put("W", "D"); put("X", "C");
        put("Y", "B"); put("Z", "A");
    }};

    private static boolean verifySize(String word) {
        return 1 <= word.length() && word.length() <= 1000;
    }

    private static String translateWord(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            String originChar = String.valueOf(word.charAt(i));

            if (verifyChar(originChar)) {
                String reversedChar = dict.get(originChar.toUpperCase());

                if (Character.isUpperCase(originChar.charAt(0))) result += reversedChar;
                else result += reversedChar.toLowerCase();

            } else {
                result += String.valueOf(originChar);
            }
        }
        return result;
    }

    private static boolean verifyChar(String c) {
        return Character.isAlphabetic(c.charAt(0));
    }

}
