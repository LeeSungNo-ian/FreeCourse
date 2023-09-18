package controller;

import static view.InputView.readLottoPurchaseValidator;
import controller.LottoCreateController;

public class LottoGameController {
    LottoCreateController lottoCreateController = new LottoCreateController();
    public void gameProgress() {
        int a = readLottoPurchaseValidator();
        lottoCreateController.createLotto(a);
    }
}
