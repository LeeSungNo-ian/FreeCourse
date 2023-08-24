package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyInput(pobi, crong)) return -1;

        int pobiMax = findMax(pobi);
        int crongMax = findMax(crong);

        if (pobiMax == crongMax) return 0;
        else if (pobiMax > crongMax) return 1;
        else return 2;
    }

    public static boolean verifyInput(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2) return false;

        if (pobi.get(0) < 3 || pobi.get(0) > 397 || crong.get(0) < 3 || crong.get(0) > 397) return false;

        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) return false;

        if (pobi.get(1) != pobi.get(0)+1 || crong.get(1) != crong.get(0)+1) return false;

        return true;
    }

    private static int findMax(List<Integer> person) {
        String leftPage = String.valueOf(person.get(0));
        String rightPage = String.valueOf(person.get(1));

        int leftMax = findPageMax(leftPage);
        int rightMax = findPageMax(rightPage);

        return leftMax > rightMax? leftMax : rightMax;
    }

    public static int findPageMax(String page) {
        int sum = 0;
        for (int i=0; i<page.length(); ++i) {
            sum += Integer.parseInt(page.substring(i, i+1));
        }

        int multiply = 1;
        for (int i=0; i<page.length(); ++i) {
            multiply *= Integer.parseInt(page.substring(i, i+1));
        }

        return sum > multiply? sum : multiply;
    }
}