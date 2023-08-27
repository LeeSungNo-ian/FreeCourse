import java.util.Stack;
import java.util.Scanner;

public class Problem2 {
    static public String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char ch: cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch: stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cryptogram = sc.nextLine();

        System.out.println(solution(cryptogram));
    }
}