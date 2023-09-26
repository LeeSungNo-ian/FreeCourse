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

    private static String[] findDuplicatedString(String cryptogram, int c1, int c2, int depth) {
        if (c2 == -1) return new String[]{cryptogram, String.valueOf(-1)};

        if (cryptogram.charAt(c1) == cryptogram.charAt(c2)) {
            if (c2 == 0) {
                return deleteDuplicatedChar(cryptogram, c2, c1);
            }
            return findDuplicatedString(cryptogram, c1-1, c2-1, depth+1);
        } else {
            if (depth == 0) return findDuplicatedString(cryptogram, c1-1, c2-1, 0);
            else {
                return deleteDuplicatedChar(cryptogram, c1, depth);
            }
        }

    }

    private static String[] deleteDuplicatedChar(String cryptogram, int c1, int depth) {
        cryptogram = cryptogram.replace(cryptogram.substring(c1, c1 + depth + 1), "");
        String[] str = {cryptogram, String.valueOf(c1)};
        return str;
    }
}


