package controller;

import view.LottoWinningNumberInput;

import static view.LottoPurchasePriceInputView.readLottoPurchasePrice;

public class LottoGameController {
    LottoCreateController lottoCreateController = new LottoCreateController();
    LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
    public void gameProgress() {
        int ticketQuantity = readLottoPurchasePrice();
        lottoCreateController.createLotto(ticketQuantity);
        lottoWinningNumberInput.readLottoWinningNumber();
    }
}
