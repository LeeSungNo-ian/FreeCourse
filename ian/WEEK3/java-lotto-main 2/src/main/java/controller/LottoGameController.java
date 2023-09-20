package controller;

import view.LottoBonusNumberInput;
import view.LottoWinningNumberInput;

import static view.LottoPurchasePriceInputView.readLottoPurchasePrice;

public class LottoGameController {
    LottoCreateController lottoCreateController = new LottoCreateController();
    LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
    LottoBonusNumberInput lottoBonusNumberInput = new LottoBonusNumberInput();

    public void gameProgress() {
        int ticketQuantity = readLottoPurchasePrice();
        lottoCreateController.createLotto(ticketQuantity);
        lottoWinningNumberInput.readLottoWinningNumber();
        lottoBonusNumberInput.readLottoBonusNumber();
    }
}
