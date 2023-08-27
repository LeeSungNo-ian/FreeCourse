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
    public static void main(String[] args) {

    }
}
