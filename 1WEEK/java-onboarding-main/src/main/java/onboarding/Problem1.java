package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        ExceptPage pageCheck = new ExceptPage();
        CalcMax pageCalculate = new CalcMax();
        ComparePage pageAnswer = new ComparePage();

        if (pageCheck.allCheck(pobi) && pageCheck.allCheck(crong))
            return pageAnswer.pageAns(pageCalculate.pageMax(pobi),pageCalculate.pageMax(crong));
        return EXCEPTION;
    }

    /**
     * 페이지 예외처리 클래스
     */
    static class ExceptPage {
        private static final int START_PAGE = 1;
        private static final int LAST_PAGE = 400;

        /*
         * 페이지의 모든 예외 검사
         */
        public boolean allCheck(List<Integer> page) {
            return inRange(page) && firstOrLast(page) && leftAndRight(page);
        }
        /*
         * 페이지가 1 ~ 400에 있는지 체크
         */
        private boolean inRange(List<Integer> page) {
            if(page.get(0)  < START_PAGE || page.get(1)  > LAST_PAGE)
                return false;
            return true;
        }
        /*
         * 왼쪽 페이지 + 1 = 오른쪽 페이지인지 체크
         */
        private boolean leftAndRight(List<Integer> page) {
            if (page.get(0) + 1 != page.get(1))
                return false;
            return true;
        }
        /*
         * 시작면 or 마지막 면인지 체크
         */
        private boolean firstOrLast(List<Integer> page) {
            if(page.get(0)  == START_PAGE || page.get(1) == LAST_PAGE)
                return false;
            return true;
        }
    }

    /**
     * 계산 클래스
     */
    static class CalcMax {
        /*
         * 덧셈 or 곱셈 중 큰 값 반환
         */
        public int pageMax(List<Integer> page) {
            int sumMax = Math.max(pageSum(page.get(0)),pageSum(page.get(1)));
            int mulMax = Math.max(pageMul(page.get(0)),pageMul(page.get(1)));
            return Math.max(sumMax,mulMax);
        }
        /*
         * 각 자리 숫자 더하기
         */
        private int pageSum(int page) {
            int sum = 0;

            while(page != 0) {
                sum += page % 10;
                page /= 10;
            }
            return sum;
        }
        /*
         * 각 자리 숫자 곱하기
         */
        private int pageMul(int page) {
            int mul = 1;

            while(page != 0) {
                mul *= page % 10;
                page /= 10;
            }
            return mul;
        }
    }


    /**
     * 비교 클래스
     */
    static class ComparePage {
        public int pageAns(int pobi, int crong) {
            if (pobi > crong)
                return POBI_WIN;
            if (pobi < crong)
                return CRONG_WIN;

            return DRAW;
        }
    }
}

