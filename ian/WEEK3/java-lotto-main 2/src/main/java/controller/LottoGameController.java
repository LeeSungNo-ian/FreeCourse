package controller;

import model.Lotto;
import model.LottoProfitCalculator;
import model.LottoRepository;
import view.LottoBonusNumberInput;
import view.LottoOutputView;
import view.LottoWinningNumberInput;

import java.util.List;
import java.util.Map;

import static model.LottoRepository.*;
import static util.RandomNumberGeneratorUtil.randomNumbersGenerate;
import static view.LottoPurchasePriceInputView.readLottoPurchasePrice;

public class LottoGameController {
    LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
    LottoBonusNumberInput lottoBonusNumberInput = new LottoBonusNumberInput();
    LottoRepository lottoRepository = new LottoRepository();
    LottoOutputView lottoOutputView = new LottoOutputView();
    LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator();

    public void gameProgress() {
        int ticketQuantity = readLottoPurchasePrice();
        System.out.println((ticketQuantity / 1000) + "개를 구매했습니다.");

        for (int count = 0; count < (ticketQuantity / 1000); count++) {
            Lotto lotto = new Lotto(randomNumbersGenerate());
            lottoRepository.addLotto(lotto);
        }

        List<Integer> winningNumbers = lottoWinningNumberInput.readLottoWinningNumber();
        int bonusNumberValue = lottoBonusNumberInput.readLottoBonusNumber();

        System.out.println(winningNumbers + "❤️");

        Map<Integer, Integer> winningDetails = lottoRepository.printLottoResult(winningNumbers, bonusNumberValue);
        lottoOutputView.showWinningResult(winningDetails);

        double lottoProfit = lottoProfitCalculator.calculateLottoProfit(winningDetails, ticketQuantity);
        lottoOutputView.showLottoProfit(lottoProfit);
    }
}
