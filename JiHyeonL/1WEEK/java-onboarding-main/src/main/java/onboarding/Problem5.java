package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        Convert changeMoney = new Convert();

        return changeMoney.result(money);
    }

    /**
     * money 변환 클래스
     */
    static class Convert {
        // 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원
        public static Integer[] change = {50000,10000,5000,1000,500,100,50,10,1};
        /*
         * money 변환 메소드
         */
        public static List<Integer> result(int money) {
            Integer[] changeMoney = {0,0,0,0,0,0,0,0,0};

            for(int i = 0; i < change.length; i++) {
                if(money == 0)
                    break;
                changeMoney[i] = money / change[i];
                money -= changeMoney[i] * change[i];
            }
            return Arrays.asList(changeMoney);
        }
    }
}
