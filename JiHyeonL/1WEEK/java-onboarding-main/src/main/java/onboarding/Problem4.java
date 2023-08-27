package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static final String EXCEPTION = "INVALID_VALUE";
    public static String solution(String word) {
        Except wordCheck = new Except();
        Convert wordConvert = new Convert();

        if(wordCheck.inRange(word))
            return wordConvert.makeWord(word);
        return EXCEPTION;
    }

    static class Except {
        public static final int MIN_LENGTH = 1;
        public static final int MAX_LENGTH = 1000;
        private static boolean inRange(String word) {
            if(word.length() < MIN_LENGTH || word.length() > MAX_LENGTH)
                return false;
            return true;
        }
    }

    static class Convert {
        public static final int LOWER_ALPHABET = 0;
        public static final int UPPER_ALPHABET = 1;
        public static final int NO_ALPHABET = -1;

        public static String makeWord(String word) {
            StringBuilder newWord = new StringBuilder();

            for(char c: word.toCharArray()) {
                if(lowerOrUpper(c) == NO_ALPHABET) {
                    newWord.append(c);
                    continue;
                }
                if(lowerOrUpper(c) == LOWER_ALPHABET) {
                    newWord.append(lowerConvert(c));
                    continue;
                }
                newWord.append(upperConvert(c));
            }

            return newWord.toString();
        }
        public static int lowerOrUpper(char c) {
            if(c >= 'a' && c <= 'z')
                return LOWER_ALPHABET;
            if(c >= 'A' && c <= 'Z')
                return UPPER_ALPHABET;
            return NO_ALPHABET;

        }

        public static char lowerConvert(char c) {
            return (char)('z' - (c - 'a'));
        }

        public static char upperConvert(char c) {
            return (char)('Z' - (c - 'A'));
        }

    }
}
