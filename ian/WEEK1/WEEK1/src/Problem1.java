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
        public static int compareValue(int page) {
            int compareLeftPageValue = Math.max(Calculator.plus(page), Calculator.multiply(page));
            int compareRightPageValue = Math.max(Calculator.plus(page + 1), Calculator.multiply(page + 1));

            return Math.max(compareLeftPageValue, compareRightPageValue);
        }
    }

    public static void main(String[] args) {

    }
}
