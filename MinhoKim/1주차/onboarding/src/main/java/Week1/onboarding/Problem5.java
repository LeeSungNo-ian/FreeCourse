package Week1.onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return Converter.convert(money);
    }

    static class Converter{

        public static List<Integer> convert(int money){
            final int[] currencies = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
            List<Integer> list = new ArrayList<>();

            for(int currency : currencies){
                if(money >= currency){
                    list.add(calculate(money, currency));
                    money %= currency;
                }
                else{
                    list.add(0);
                }
            }

            return list;
        }

        public static int calculate(int money, int currency){
            return money / currency;
        }
    }
}
