package week1;
import java.util.Scanner;

public class Problem2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("암호문을 입력하세요: ");
        String cryptogram = scanner.nextLine();

        scanner.close();

        String result = solution(cryptogram);
        System.out.println(result);
    }

    public static String solution(String cryptogram) {
        StringBuilder decrypted = new StringBuilder(cryptogram);

        while (true) {
            boolean removed = false;
            int length = decrypted.length();

            for (int i = 0; i < length - 1; i++) {
                if (decrypted.charAt(i) == decrypted.charAt(i + 1)) {
                    decrypted.delete(i, i + 2);
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                break;
            }
        }

        return decrypted.toString();
    }
}
