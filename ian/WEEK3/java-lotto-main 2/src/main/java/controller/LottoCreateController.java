package controller;

import model.Lotto;
import model.LottoRepository;
import view.LottoPurchasePriceInputView;

import static util.RandomNumberGeneratorUtil.randomNumbersGenerate;

public class LottoCreateController {
    LottoRepository lottoRepository = new LottoRepository();

    public void createLotto(int price) {
        int totalLottoCount = countTotalLotto(price);
        System.out.println(totalLottoCount + "개를 구매했습니다.");

        for (int count = 0; count < totalLottoCount; count++) {
            Lotto lotto = new Lotto(randomNumbersGenerate());
            lottoRepository.addLotto(lotto);
        }
    }

    private int countTotalLotto(int price) {
        int totalCount = price / 1000;
        return totalCount;
    }
}
