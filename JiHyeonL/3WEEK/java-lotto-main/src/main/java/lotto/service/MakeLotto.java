package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * 로또 발행 클래스
 */
public class MakeLotto {

    /*
     * 랜덤 로또 발행하기
     */
    public List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Info.START_NUMBER.getValue(), Info.END_NUMBER.getValue(), Info.COUNT_NUMBERS.getValue());
    }
    /*
     * 로또 몇개 구매했는지 계산
     */
    public int quantity(int cost) {
        return cost / Info.LOTTO_UNIT.getValue();
    }

}
