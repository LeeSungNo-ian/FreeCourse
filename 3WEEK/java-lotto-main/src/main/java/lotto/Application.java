package lotto;

import lotto.controller.LottoGame;

/**
 * 클라이언트 역할 + 테스트
 */
public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
