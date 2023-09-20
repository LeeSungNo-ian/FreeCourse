package view;

import camp.nextstep.edu.missionutils.Console;
import validator.WinnerNumberGeneratorValidator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWinningNumberInput {
    WinnerNumberGeneratorValidator winnerNumberGeneratorValidator = new WinnerNumberGeneratorValidator();

    public List<Integer> readLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winnnigLottoNumber = Console.readLine();
        List<Integer> winningNumbers = commaSeparatedStringToIntList(winnnigLottoNumber);
        return winningNumbers;
    }

    private List<Integer> commaSeparatedStringToIntList(String winnnigLottoNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber: winnnigLottoNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }
        Collections.sort(winningNumbers);
        System.out.println(winningNumbers);
        vaildWinnerNumbers(winningNumbers);
        return winningNumbers;
    }

    private void vaildWinnerNumbers(List<Integer> winningNumbers) {
        winnerNumberGeneratorValidator.vaildWinnerNumbers(winningNumbers);
    }
}
