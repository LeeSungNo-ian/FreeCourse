package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

/**
 * 유저 입력 클래스
 */
public class InputView {

    /*
     * "구입금액을 입력해 주세요."와 함께 유저에게 로또 금액 받는 메소드
     */
    public String getLottoCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }
    /*
     * "당첨 번호를 입력해 주세요."와 함께 유저에게 당첨번호 숫자 6개 받는 메소드
     */
    public String getAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }
    /*
     * "보너스 번호를 입력해 주세요."와 함께 보너스 번호 1개 받는 메소드
     */
    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }
}
