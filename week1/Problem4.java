package week1;
public class Problem4 {
    public static void main(String[] args) {
        String word = "word";
        String result = solution(word);
        System.out.println(result);
    }

    public static String solution(String word) {
        StringBuilder transformed = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char newChar = (char)('a' + ('z' - c));
                transformed.append(newChar);
            } else if (Character.isUpperCase(c)) {
                char newChar = (char)('A' + ('Z' - c));
                transformed.append(newChar);
            } else {
                transformed.append(c);
            }
        }

        return transformed.toString();
    }
}
