package view;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoPurchaseValidator;

public class InputView {
    static LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();

    public static void readLottoPurchaseValidator() {
        System.out.println("구입금액을 입력해 주세요. ✏️");
        String lottoPurchaseAmount = Console.readLine();
        lottoPurchaseValidator.validPurchasAmount(lottoPurchaseAmount);
    }
}
