package view;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusNumberInput {
    public void readLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요. ✏️");
        String bonusNumber = Console.readLine();
        int bonusNumberValue = Integer.parseInt(bonusNumber);
        System.out.println(bonusNumberValue);
    }
}
