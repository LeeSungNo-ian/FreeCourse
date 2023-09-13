package lotto.exception;

import lotto.service.Info;

import java.util.List;

/**
 * 입력 예외처리 클래스: 이곳에서 에러가 발생하지 않아야 일급 컬렉션에 데이터를 저장할 수 있다.
 */
public class Exception {
    /*
     * 로또 구입 금액 예외처리 메소드를 모두 실행
     */
    public void isCostValid(String input) {
        isStringNumber(input);  // 숫자 체크
        isCostDividedUnit(Integer.parseInt(input));   // 숫자이면 1000으로 나누어 떨어지는지 체크
    }
    /*
     * 당첨 번호 예외처리 메소드를 모두 실행
     */
    public void isAnswerValid(List<String> input) {
        isAnswerCountSixAndValidSplit(input);   // 번호가 6개인지 체크
        isNumbersNotSame(input);    // 번호 중 중복이 있는지 체크
        for (String str : input) {
            isStringNumber(str);    // 번호가 숫자인지 체크
            isNumberInRange(Integer.parseInt(str));   // 숫자이면 번호 범위 체크
        }
    }
    /*
     * 보너스 번호 예외처리 메소드를 모두 실행
     */
    public void isBonusValid(String input) {
        isStringNumber(input);   // 문자열 숫자인지 체크
        isNumberInRange(Integer.parseInt(input));  // 숫자이면 번호 범위 체크
    }

    /*
     * 문자열이 숫자인지 체크
     */
    private void isStringNumber(String str) {
        if(!str.matches("[0-9]+"))
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 번호가 존재합니다.");
    }
    /*
     * 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는지 체크
     */
    private void isCostDividedUnit(int cost) {
        if(cost % Info.LOTTO_UNIT.getValue() != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 " + Info.LOTTO_UNIT.getValue() + "로 나누어 떨어지지 않습니다.");
    }
    /*
     * 당첨 번호가 6개인지 체크
     */
    private void isAnswerCountSixAndValidSplit(List<String> numbers) {
        if (numbers.size() != Info.COUNT_NUMBERS.getValue())
            throw new IllegalArgumentException("[ERROR] 입력하신 로또 번호 개수가 " + Info.COUNT_NUMBERS.getValue() + "가 아닙니다.");
    }
    /*
     * 중복 숫자가 존재하는지 체크
     */
    private void isNumbersNotSame(List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++)
            if (numbers.indexOf(numbers.get(i)) != numbers.lastIndexOf(numbers.get(i)))
                throw new IllegalArgumentException("[ERROR] 중복 번호가 존재합니다.");
    }
    /*
     * 숫자 범위가 1~45인지 체크
     */
    private void isNumberInRange(int number) {
        if (number < Info.START_NUMBER.getValue() || number > Info.END_NUMBER.getValue())
            throw new IllegalArgumentException("[ERROR] 입력하신 번호 중 " + Info.START_NUMBER.getValue() + " ~ " + Info.END_NUMBER.getValue() + " 범위가 아닌 숫자가 존재합니다.");
    }

}
