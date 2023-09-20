package validator;

public class LottoPurchaseValidator {
    public int validPurchasAmount(String purchaseAmount) {
        vaildIntegerPurchasAmount(purchaseAmount);
        int purchaseAmountPrice = Integer.parseInt(purchaseAmount);
        validMinimumPurchaseAmount(purchaseAmountPrice);
        validPurchaseDivideUp1000(purchaseAmountPrice);

        return purchaseAmountPrice;
    }

    private void vaildIntegerPurchasAmount(String input) {
        String regex = "[+-]?\\d*(\\.\\d+)?";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액에는 숫자만 입력해주세요.");
        }
    }

    private void validMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 최소 구입금액은 1000원 입니다.");
        }
    }

    private void validPurchaseDivideUp1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 단위여야 합니다.");
        }
    }
}
