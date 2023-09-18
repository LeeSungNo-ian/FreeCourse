package controller;

import static view.LottoPurchasePriceInputView.readLottoPurchasePrice;

public class LottoGameController {
    LottoCreateController lottoCreateController = new LottoCreateController();
    public void gameProgress() {
        int a = readLottoPurchasePrice();
        lottoCreateController.createLotto(a);
    }
}
