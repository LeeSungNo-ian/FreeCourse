package lotto.controller;


import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.Pay;
import lotto.domain.RandomLotto;
import lotto.exception.Exception;
import lotto.service.Calculate;
import lotto.service.Info;
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
        Exception exception = new Exception();
        try {
            // 1) 금액 입력 & 예외처리
            String cost = input.getLottoCost();   // 금액 입력
            exception.isCanConvertInt(cost);    // 입력을 int로 바꿀 수 있는지 확인
            Pay validPay = new Pay(convertStringToInt(cost));  // 금액 예외처리 후 int 형태로 Pay 도메인에 저장
            System.out.println();

            // 2) 로또 발행 후 출력
            List<RandomLotto> generatedLottoList = runMakeLotto(validPay.getCost()); // 금액만큼 랜덤 로또 발행
            output.printMakeLotto(generatedLottoList);   // 모든 로또 출력
            System.out.println();

            // 3) 당첨, 보너스 번호 입력 & 예외처리
            String answerNumbers = input.getAnswerNumbers();    // 당첨번호 입력
            List<String> answerList = splitStringToList(answerNumbers); // string 리스트로 split
            exception.isConConvertIntList(answerList);   // string<Integer>로 바꿀 수 있는지 체크
            Lotto validLotto = new Lotto(convertStringListToIntList(answerList));  // 당첨번호 예외처리 후 List<Integer> 형태로 Lotto 도메인에 저장
            System.out.println();

            String bonusNumber = input.getBonusNumber();    // 보너스 번호 입력
            exception.isCanConvertInt(bonusNumber);    // 입력을 int로 바꿀 수 있는지 확인
            BonusLotto validBonus = new BonusLotto(convertStringToInt(bonusNumber));    // 보너스번호 예외처리 후 int 형태로 BonusLotto 도메인에 저장
            System.out.println();

            // 4) 로또 계산
            List<Integer> rankList = runCalcualte(validLotto.getLotto(), validBonus.getBonus(), generatedLottoList);

            // 5) 당첨 통계 출력
            output.printResultAnalysis(rankList);
            output.printWinRateLotto(calculate.winRateFormat(rankList, validPay.getCost()));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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
        // 0으로 초기화
        for (int i = 0; i < Info.RANK_LENGTH.getValue(); i++) {
            rankCountList.add(0);
        }

        Calculate calculate = new Calculate();

        for (RandomLotto lotto : lottoList) {
            int rank = calculate.compareLottoAndReturnRank(answer,bonus,lotto.getRandomLotto());
            if (rank == -1)
                continue;
            rankCountList.set(rank,rankCountList.get(rank)+1);
        }

        return rankCountList;
    }


    /*
     * String 입력을 "," 를 기준으로 나누어 String List로 변환
     */
    public List<String> splitStringToList(String input) {
        List<String> stringList = Arrays.asList(input.split(","));
        return stringList;
    }
    /*
     * String List를 Integer List로 변환
     */
    public List<Integer> convertStringListToIntList(List<String> numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (String str : numbers)
            integerList.add(convertStringToInt(str));
        return integerList;
    }
    /*
     * String을 int로 변환
     */
    public int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }
}
