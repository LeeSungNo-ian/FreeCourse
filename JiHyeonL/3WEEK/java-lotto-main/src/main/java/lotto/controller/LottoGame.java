package lotto.controller;


import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.Pay;
import lotto.domain.RandomLotto;
import lotto.dto.InputDTO;
import lotto.service.Calculate;
import lotto.service.MakeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    public void start() {
        InputView input = new InputView();
        OutputView output = new OutputView();
        Calculate calculate = new Calculate();

        // 1) 금액 입력
        String cost = input.getLottoCost();   // 금액 입력
        InputDTO inputCost = new InputDTO(cost);   // 예외처리를 위해 DTO 활용
        Pay validPay = inputCost.costValidate();  // 금액 예외처리 후 int 형태로 Pay 도메인에 저장

        // 2) 로또 발행 후 출력
        List<RandomLotto> generatedLottoList = runMakeLotto(validPay.getCost()); // 금액만큼 랜덤 로또 발행
        output.printMakeLotto(generatedLottoList);   // 모든 로또 출력

        // 3) 당첨번호 입력
        String answerNumbers = input.getAnswerNumbers();    // 당첨번호 입력
        InputDTO inputAnswer = new InputDTO(splitStringToList(answerNumbers));   // 예외처리를 위해 DTO 활용
        Lotto validLotto = inputAnswer.answerValidate();  // 당첨번호 예외처리 후 List<Integer> 형태로 Lotto 도메인에 저장

        String bonusNumber = input.getBonusNumber();    // 보너스 번호 입력
        InputDTO inputBonus = new InputDTO(bonusNumber);    // 예외처리를 위해 DTO 활용
        BonusLotto validBonus = inputBonus.bonusValidate();    // 보너스번호 예외처리 후 int 형태로 BonusLotto 도메인에 저장

        // 4) 로또 계산
        List<Integer> rankCountList = runCalcualte(validLotto.getLotto(),validBonus.getBonus(),generatedLottoList);

        // 5) 당첨 통계 출력
        output.printResultAnalysis(rankCountList);
        output.printWinRateLotto(calculate.winRateFormat(rankCountList,validPay.getCost()));


    }

    /*
     * 구매한 로또 개수만큼 로또 발행
     */
    public List<RandomLotto> runMakeLotto(int cost) {
        MakeLotto make = new MakeLotto();
        List<RandomLotto> lottoList = new ArrayList<>();

        for(int i = 0; i < make.quantity(cost); i++) {
            lottoList.add(new RandomLotto(make.randomNumbers()));
        }
        return lottoList;
    }
    /*
     * 당첨되었는지 모든 로또 계산
     */
    public List<Integer> runCalcualte(List<Integer> answer, int bonus, List<RandomLotto> lottoList) {
        // [1등,2등,3등,4등,5등] 각 인덱스가 등수-1이고, 값이 count인 리스트
        List<Integer> rankCountList = new ArrayList<>();

        Calculate calculate = new Calculate();

        for (RandomLotto lotto : lottoList) {
            int rank = calculate.compareLottoAndReturnRank(answer,bonus,lotto.getRandomLotto());
            if (rank == -1)
                continue;
            rankCountList.add(rank,rankCountList.get(rank)+1);
        }
        return rankCountList;
    }


    /*
     * String 입력을 "," 를 기준으로 나누어 String List로 변환
     */
    public List<String> splitStringToList(String input) {
        return Arrays.asList(input.split(","));
    }
}
