package onboarding;

public class Problem3 {
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
