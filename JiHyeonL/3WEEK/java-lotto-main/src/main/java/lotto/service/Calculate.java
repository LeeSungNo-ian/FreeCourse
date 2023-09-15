package lotto.service;

import lotto.domain.RandomLotto;

import java.util.Collections;
import java.util.List;

/**
 * 로또 당첨됐는지 판단하는 클래스
 */
public class Calculate {

    /*
     * 로또 당첨번호와 발행한 로또를 비교하여 등수 인덱스로 반환
     * 순위에 해당되지 않으면 -1 반환
     */
    public int compareLottoAndReturnRank(List<Integer> answer, int bonus, List<Integer> lotto) {
        int count = 0;
        int bonusCount = 0;

        for (int number : lotto) {
            if (answer.contains(number))
                count++;
            if (bonus == number)
                bonusCount = 1;
        }
        return Rank.getCountToRank(count,bonusCount); // count를 등수 인덱스로 변환 후 리턴
    }
    /*
     * 수익률 계산한 뒤 문자열로 반환하는 메소드
     */
    public float winRateFormat(List<Integer> countList, int cost) {
        int totalProfit = 0;
        Collections.reverse(countList);

        for(int count : countList) {
            totalProfit += count * Rank.getRankList().get(count);
        }
        return (totalProfit / cost) * 100f;
    }

}
