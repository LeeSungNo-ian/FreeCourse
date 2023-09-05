package util;

public class ParsingUtil {
    private static final Integer LENGTH = 3;

    public static Integer[] parseUserInput(String input, boolean isCorrect){
        Integer[] numbers = new Integer[LENGTH];

        for(int i=0;i<numbers.length;i++){
            numbers[i] = charToInteger(input, isCorrect, i);
        }

        return numbers;
    }

    private static Integer charToInteger(String input, boolean isCorrect, int i){
        Integer number = 0;

        number = Character.getNumericValue(input.charAt(i));

        return number;
    }


    public static boolean isCorrectInput(String input){
        return isCorrectRegex(input) && isCorrectLength(input);
    }
    private static boolean isCorrectLength(String input){
        if (input.length() != LENGTH) throw new IllegalArgumentException("3자리 숫자를 입력하지 않았습니다.");
        return true;
    }

    private static boolean isCorrectRegex(String input) {
        if (!input.matches("^[1-9]*$")) throw new IllegalArgumentException("1-9까지의 숫자가 아닌 입력값입니다.");
        return true;
    }

}
