public class Problem1 {
    static class Calculator {
        public static int plus(int page) {
            int result = 0;
            while (page > 0) {
                result += page % 10;
                page /= 10;
            }
            return result;
        }

        public static int multiply(int page) {
            int result = 1;
            while (page > 0) {
                result *= page % 10;
                page /= 10;
            }
            return result;
        }
    }

    static class Comparison {
        public static int compareLeftRightValue(int page) {
            int compareLeftPageValue = Math.max(Calculator.plus(page), Calculator.multiply(page));
            int compareRightPageValue = Math.max(Calculator.plus(page + 1), Calculator.multiply(page + 1));

            return Math.max(compareLeftPageValue, compareRightPageValue);
        }
    }

    static class Result {
        static final int POBI_WIN = 1;
        static final int CRONG_WIN = 2;
        static final int DRAW = 0;
        static final int EXCEPTION = -1;

        public static int resultPobiCrongValues(int pobiValue, int crongValue) {
            if (pobiValue > crongValue) {
                return POBI_WIN;
            } else if (pobiValue < crongValue) {
                return CRONG_WIN;
            } else if (pobiValue == crongValue) {
                return DRAW;
            } else {
                return EXCEPTION;
            }
        }
    }

    public static void main(String[] args) {

    }
}
