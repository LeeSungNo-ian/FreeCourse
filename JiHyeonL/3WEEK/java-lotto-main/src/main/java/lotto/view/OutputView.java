package lotto.view;

import lotto.domain.RandomLotto;
import lotto.service.Rank;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OutputView {
    /*
     * 구매한 모든 로또 출력
     */
    public void printMakeLotto(List<RandomLotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for (RandomLotto lotto : lottoList) {
            System.out.println(lotto.getRandomLottoToString());
        }
    }
    /*
     * 당첨 통계를 출력하는 메소드 using Rank enum
     */
    public void printResultAnalysis(List<Integer> countList) {
        Collections.reverse(countList);

        System.out.println("당첨 통계");
        System.out.println("---");

        int i = countList.size()-1;
        for (String description : Rank.getDescriptionList()) {
            System.out.println(description + countList.get(i) + "개");
            i--;
        }
    }
    /*
     * 수익률 출력
     */
    public void printWinRateLotto(float winRate) {
        System.out.println("총 수익률은 " + String.format("%2f",winRate) + "%입니다.");
    }
}
