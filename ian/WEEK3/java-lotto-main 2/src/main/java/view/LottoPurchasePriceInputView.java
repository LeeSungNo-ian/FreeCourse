package view;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoPurchaseValidator;
import model.LottoTicketQuantity;

public class LottoPurchasePriceInputView {
    static LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();
    static LottoTicketQuantity lottoTicketQuantity = new LottoTicketQuantity();

    public static int readLottoPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요. ✏️");
        String lottoPurchaseAmount = Console.readLine();
        int lottoPurchasePrice = lottoPurchaseValidator.validPurchaseAmount(lottoPurchaseAmount);
        return lottoPurchasePrice;
    }
}
