package controller;

import model.Lotto;
import model.LottoRepository;
import view.LottoBonusNumberInput;
import view.LottoWinningNumberInput;

import java.util.List;
import java.util.Map;

import static model.LottoRepository.*;
import static util.RandomNumberGeneratorUtil.randomNumbersGenerate;
import static view.LottoPurchasePriceInputView.readLottoPurchasePrice;

public class LottoGameController {
    LottoCreateController lottoCreateController = new LottoCreateController();
    LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
    LottoBonusNumberInput lottoBonusNumberInput = new LottoBonusNumberInput();
    LottoRepository lottoRepository = new LottoRepository();

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
        showWinningResult(winningDetails);
    }

    public void showWinningResult(Map<Integer, Integer> lottoWinningStatistics) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoWinningStatistics.get(RANK_FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoWinningStatistics.get(RANK_FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoWinningStatistics.get(RANK_THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningStatistics.get(RANK_SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinningStatistics.get(RANK_FIRST) + "개");
    }
}
