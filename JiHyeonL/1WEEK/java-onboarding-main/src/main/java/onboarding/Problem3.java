package onboarding;

public class Problem3 {
    public static final int EXCEPTION = -1;
    public static int solution(int number) {
        ExceptNum numCheck = new ExceptNum();
        GamePlay numCount = new GamePlay();

        if(numCheck.inRange(number))
            return numCount.countClap(number);
        return EXCEPTION;
    }

    /**
     * 숫자 예외처리 클래스
     */
    static class ExceptNum {
        public static final int MIN_NUM = 1;
        public static final int MAX_NUM = 10000;
        /*
         * 숫자가 범위 안에 있는지 체크
         */
        public static boolean inRange(int number) {
            if(number < MIN_NUM && number > MAX_NUM)
                return false;
            return true;
        }
    }

    /**
     * 손뼉 횟수 반환 클래스
     */
    static class GamePlay {
        /*
         * 하나씩 369 찾는 메소드 (나중에 효율적인 코드로 수정하기)
         */
        public static int countClap(int number) {
            int result = 0;
            for(int i = 1; i <= number; i++) {
                int temp = i;
                while(temp != 0) {
                    if(temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9)
                        result += 1;
                    temp /= 10;
                }
            }
            return result;
        }

    }
}
