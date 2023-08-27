package Week1.onboarding;

import java.util.LinkedHashSet;

public class Problem2 {

    static Code code = new Code();

    public String solution(String cryptogram){
        return code.decode(cryptogram);
    }

    static class Code{

        public String decode(String cryptogram){
            LinkedHashSet<Character> charSet = new LinkedHashSet<>();

            for(int i=0; i<cryptogram.length(); i++){
                charSet.add(cryptogram.charAt(i));
            }

            StringBuilder result = new StringBuilder();
            for(Character c : charSet){
                result.append(c);
            }
            return result.toString();
        }
    }
}
