package onboarding;

public class Problem3 {
    static int sum = 0;
    public static int solution(int number) {
        int answer = game369(1, number);
        return answer;
    }

    static int game369(int curr, int number) {
        if (curr == number+1) return sum;
        sum += clap(curr);
        return game369(curr+1, number);
    }
    static int clap(int curr) {
        int clap = 0;
        String cur = String.valueOf(curr);
        for (int i=0; i<cur.length(); i++) {
            if (cur.charAt(i) == '3' || cur.charAt(i) == '6' || cur.charAt(i) == '9') {
                clap++;
            }
        }
        return clap;
    }
}
