package Week1.onboarding;

public class Problem4 {

    public static String solution(String word) {
        return new Converter().convert(word);
    }

     static class Converter{
        public String convert(String word){
            StringBuilder str = new StringBuilder();
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(isUpperCase(c)){ // 대문자 알파벳인 경우
                    int distance = c - 'A';
                    str.append((char) ('Z' - distance));
                }else if(isLowerCase(c)){ // 소문자 알파벳인 경우
                    int distance = c - 'a';
                    str.append((char) ('z' - distance));
                }
            }

            return str.toString();
        }

        public static boolean isLowerCase(char word){
            if(word >= 'a' && word <= 'z')
                return true;

            return false;
        }

        public static boolean isUpperCase(char word){
            if(word >= 'A' && word <= 'Z')
                return true;

            return false;
        }
    }
}
