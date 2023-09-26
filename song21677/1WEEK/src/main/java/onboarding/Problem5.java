package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return withdrawMoney(money);
    }

    static public List<Integer> withdrawMoney(int money) {
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> list = new ArrayList<>();
        for (int e : arr) {
            if (money >= e) {
                int num = money/e;
                list.add(num);

                money -= num * e;
            } else {
                list.add(0);
            }
        }
        return list;
    }
}

