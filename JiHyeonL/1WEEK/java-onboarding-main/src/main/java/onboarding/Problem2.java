package onboarding;

import java.util.Stack;

public class Problem2 {
    public static final String EXCEPTION = "INVALID INPUT";
    public static String solution(String cryptogram) {
        ExceptString strCheck = new ExceptString();
        FindSame strNoSame = new FindSame();

        if(strCheck.allCheck(cryptogram))
            return strNoSame.removeSame(cryptogram);
        return EXCEPTION;
    }

    /**
     * string 제한사항 확인 클래스
     */
    static class ExceptString {
        public static final int MIN_LENGTH = 1;
        public static final int MAX_LENGTH = 1000;
        /*
         * 모든 예외 케이스 확인
         */
        public static boolean allCheck(String crypto) {
            return inRange(crypto) && lowerAlphabet(crypto);
        }
        /*
         * cryptogram의 길이가 1 이상 1000 이하인지 확인
         */
        private static boolean inRange(String crypto) {
            if(crypto.length() >= MIN_LENGTH && crypto.length() <= MAX_LENGTH)
                return true;
            return false;
        }
        /*
         * cryptogram이 알파벳 소문로만 이루어져 있는지 확인
         */
        private static boolean lowerAlphabet(String crypto) {
            for(int i = 0; i < crypto.length(); i++) {
                char c = crypto.charAt(i);
                if(c < 'a' || c > 'z')
                    return false;
            }
            return true;
        }
    }

    /**
     * 중복 문자열 제거 클래스
     */
    static class FindSame {
        /*
         * 문자열 중복 제거
         */
        public String removeSame(String crypto) {
            Stack<Character> stack = new Stack<>();

            for(Character c: crypto.toCharArray()) {
                // 스택 비어있는 경우 제외하고 스택 맨 위 값 = 현재 값이면 스택 값 제거
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                    continue;
                }
                // 스택 맨 위 값 != 현재 값이면 현재 값 추가
                stack.push(c);
            }

            // 문자열 변환
            StringBuilder answer = new StringBuilder();
            while(!stack.isEmpty()) {
                answer.append(stack.pop());
            }
            return answer.reverse().toString();
        }
    }


}
