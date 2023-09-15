package lotto.dto;

import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.Pay;
import lotto.exception.Exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 구매금액 & 보너스 1개 번호, 로또 6개 번호에 대한 dto
 * -> input값 예외처리 용도로 사용하는 객체.
 */
public class InputDTO {
    private String stringInput;
    private List<String> ListInput;

    public InputDTO(String cost) {
        this.stringInput = cost;
    }
    public InputDTO(List<String> answer) {
        this.ListInput = answer;
    }

    /*
     * valid 검사에서 에러 발생하지 않으면 값을 domain으로 보낸다.
     */
    public Pay costValidate() {
        Exception exception = new Exception();
        exception.isCostValid(stringInput);
        Pay pay = new Pay(convertStringToInt(stringInput));
        return pay;
    }
    public Lotto answerValidate() {
        Exception exception = new Exception();
        exception.isAnswerValid(ListInput);
        Lotto lotto = new Lotto(convertStringListToIntList(ListInput));
        return lotto;
    }
    public BonusLotto bonusValidate() {
        Exception exception = new Exception();
        exception.isBonusValid(stringInput);
        BonusLotto bonusLotto = new BonusLotto(convertStringToInt(stringInput));
        return bonusLotto;
    }


    /*
     * String List를 Integer List로 변환
     */
    public List<Integer> convertStringListToIntList(List<String> numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (String str : numbers)
            integerList.add(convertStringToInt(str));
        return integerList;
    }
    /*
     * String을 int로 변환
     */
    public int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }
}
