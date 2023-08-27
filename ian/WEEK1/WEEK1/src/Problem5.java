public class Problem5 {
    public static int[] solution(int money) {
        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = new int[coin.length];

        for (int i = 0; i < coin.length; i++) {
            result[i] = money / coin[i];
            money %= coin[i];
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
