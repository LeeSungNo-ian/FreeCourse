package controller;

import view.LottoPurchasePriceInputView;

import static util.RandomNumberGeneratorUtil.randomNumbersGenerate;

public class LottoCreateController {
    public void createLotto(int price) {
        long totalLottoCount = countTotalLotto(price);
        LottoPurchasePriceInputView inputLotto = new LottoPurchasePriceInputView();
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
