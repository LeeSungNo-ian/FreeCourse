package Week1.onboarding;

import java.util.LinkedHashSet;

public class Problem2 {

    static Code code = new Code();
    static Validation validation = new Validation();

    public String solution(String cryptogram){
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
