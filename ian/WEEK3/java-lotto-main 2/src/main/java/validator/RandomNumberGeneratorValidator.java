package validator;

import java.util.List;

public class RandomNumberGeneratorValidator {
    public void vaildRandomNumbers(List<Integer> numbers) {
        vaildRandomNumberRange(numbers);
        vaildRandomNumberSize(numbers);
    }

    void vaildRandomNumberRange(List<Integer> randomNumbers) {
        System.out.println(randomNumbers + "👀");
        for (int randomNumber: randomNumbers) {
            if (randomNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 난수 생성 시 최소값(1) 보다 작은 값이 있습니다.");
            }
            if (randomNumber > 46) {
                throw new IllegalArgumentException("[ERROR] 난수 생성 시 최대값(45) 보다 큰 값이 있습니다.");
            }
        }
    }

    void vaildRandomNumberSize(List<Integer> randomNumbers) {
        if (randomNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 난수가 6개로 생성되지 않았습니다.");
        }
    }
}
