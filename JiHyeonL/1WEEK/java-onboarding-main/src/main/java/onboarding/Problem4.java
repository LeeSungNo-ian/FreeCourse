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

    /**
     * 예외처리 클래스
     */
    static class Except {
        public static final int MIN_LENGTH = 1;
        public static final int MAX_LENGTH = 1000;
        private static boolean inRange(String word) {
            if(word.length() < MIN_LENGTH || word.length() > MAX_LENGTH)
                return false;
            return true;
        }
    }

    /**
     * 알파벳 변환 클래스
     */
    static class Convert {
        public static final int LOWER_ALPHABET = 0;
        public static final int UPPER_ALPHABET = 1;
        public static final int NO_ALPHABET = -1;
        /*
         * 알파벳이 아니면 그대로, 대문자면 대문자 반대로, 소문자면 소문자 반대로 변환해주는 메소드
         */
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
        /*
         * 소문자 or 대문자 or 알파벳 아님 상태를 알려주는 메소드
         */
        public static int lowerOrUpper(char c) {
            if(c >= 'a' && c <= 'z')
                return LOWER_ALPHABET;
            if(c >= 'A' && c <= 'Z')
                return UPPER_ALPHABET;
            return NO_ALPHABET;

        }
        /*
         * 소문자 단어 변환 메소드
         */
        public static char lowerConvert(char c) {
            return (char)('z' - (c - 'a'));
        }
        /*
         * 대문자 단어 변환 메소드
         */
        public static char upperConvert(char c) {
            return (char)('Z' - (c - 'A'));
        }

    }
}
