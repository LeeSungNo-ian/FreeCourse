import java.util.Scanner;

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

    enum ResultValue {
        POBI_WIN(1), CRONG_WIN(2), DRAW(0), EXCEPTION(-1);
        final private int value;

        ResultValue(int value) {
            this.value = value;
        }

        int getDay() {
            return value;
        }
    }

    static class Result {
        public static int resultPobiCrongValues(int pobiValue, int crongValue) {
            if (pobiValue > crongValue) {
                return ResultValue.POBI_WIN.value;
            } else if (pobiValue < crongValue) {
                return ResultValue.CRONG_WIN.value;
            } else if (pobiValue == crongValue) {
                return ResultValue.DRAW.value;
            } else {
                return ResultValue.EXCEPTION.value;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pobiPageNumber = sc.nextInt();
        int crongPageNumber = sc.nextInt();

        int pobiPoint = Comparison.compareLeftRightValue(pobiPageNumber);
        int crongPoint = Comparison.compareLeftRightValue(crongPageNumber);

        System.out.println(Result.resultPobiCrongValues(pobiPoint, crongPoint));
    }
}
