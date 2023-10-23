package Week1.onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    static Code code = new Code();
    static Validation validation = new Validation();

    public static String solution(String cryptogram){
        if(validation.isNotNull(cryptogram)){
            return code.decode(cryptogram);
        }
        return "cryptogram is empty";
    }

    static class Validation{
        public boolean isNotNull(String cryptogram){
            return cryptogram.length() != 0;
        }
    }

    static class Code{
        public static String decode(String cryptogram){
            Stack<Character> stack = new Stack<>();

            int index = 0;
            while (index < cryptogram.length()) {
                if (stack.isEmpty() || !stack.peek().equals(cryptogram.charAt(index))) {
                    stack.push(cryptogram.charAt(index));
                    ++index;
                    continue;
                }
                while (index < cryptogram.length() && stack.peek().equals(cryptogram.charAt(index))) {
                    ++index;
                }
                stack.pop();
            }

            return stack.stream().map(Object::toString).collect(Collectors.joining());
        }
    }
}
