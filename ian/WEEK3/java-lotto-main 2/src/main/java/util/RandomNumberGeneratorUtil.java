package util;

import camp.nextstep.edu.missionutils.Randoms;
import validator.RandomNumberGeneratorValidator;

import java.util.Collections;
import java.util.List;

public class RandomNumberGeneratorUtil {
    public static RandomNumberGeneratorValidator randomNumberGeneratorValidator = new RandomNumberGeneratorValidator();

    public static List<Integer> randomNumbersGenerate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers);
        randomNumberGeneratorValidator.vaildRandomNumbers(randomNumbers);
        return randomNumbers;
    }
}
