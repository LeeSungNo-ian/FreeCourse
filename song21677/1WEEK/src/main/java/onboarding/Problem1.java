package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyInput(pobi, crong)) return -1;
        return 0;
    }

    public static boolean verifyInput(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2) return false;

        if (pobi.get(0) < 3 || pobi.get(0) > 397 || crong.get(0) < 3 || crong.get(0) > 397) return false;

        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) return false;

        if (pobi.get(1) != pobi.get(0)+1 || crong.get(1) != crong.get(0)+1) return false;

        return true;
    }
}