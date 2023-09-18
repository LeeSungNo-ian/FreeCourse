package view;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoPurchaseValidator;
import model.LottoTicketQuantity;

public class InputView {
    static LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();
    static LottoTicketQuantity lottoTicketQuantity = new LottoTicketQuantity();

    public static void readLottoPurchaseValidator() {
        System.out.println("구입금액을 입력해 주세요. ✏️");
        String lottoPurchaseAmount = Console.readLine();
        int lottoPurchasePrice = lottoPurchaseValidator.validPurchasAmount(lottoPurchaseAmount);
        int lottoTicketQuantity = LottoTicketQuantity.countLottoTicketQuantity(lottoPurchasePrice);
        System.out.println(lottoTicketQuantity + "개를 구매했습니다.");
    }
}
