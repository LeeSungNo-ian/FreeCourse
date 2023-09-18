package controller;

import model.Lotto;
import util.RandomNumberGeneratorUtil;
import view.InputView;

import static util.RandomNumberGeneratorUtil.randomNumbersGenerate;

public class LottoCreateController {
    public void createLotto(int price) {
        long totalLottoCount = countTotalLotto(price);
        InputView inputLotto = new InputView();
        System.out.println(totalLottoCount + "개를 구매했습니다.");

        for (int count = 0; count < totalLottoCount; count++) {
            randomNumbersGenerate();
        }
    }

    private int countTotalLotto(int price) {
        int totalCount = price / 1000;
        return totalCount;
    }
}
