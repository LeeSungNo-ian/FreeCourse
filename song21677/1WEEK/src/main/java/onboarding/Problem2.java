package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int idx = cryptogram.length()-1;
        while (true) {
            String[] str = findDuplicatedString(cryptogram, idx, idx - 1, 0);
            idx = Integer.parseInt(str[1]);
            if (idx == -1) break;
            cryptogram = str[0];
        }
        answer = cryptogram;
        return answer;
    }
}
