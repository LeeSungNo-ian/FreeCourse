package org.example;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

    public class GameManager {
        private final List<Integer> computerNumbers;
        private final List<Integer> userNumbers;
        private int attempts;

        public GameManager() {
            computerNumbers = generateComputerNumbers();
            userNumbers = new ArrayList<>();
            attempts = 0;
        }

        private List<Integer> generateComputerNumbers() {
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }
            return numbers;
        }

        public String guessUserNumbers(List<Integer> inputNumbers) {
            attempts++;
            userNumbers.clear();
            userNumbers.addAll(inputNumbers);

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                    strikes++;
                } else if (computerNumbers.contains(userNumbers.get(i))) {
                    balls++;
                }
            }

            if (strikes == 3) {
                return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }

            return String.format("%d볼 %d 스트라이크", balls, strikes);
        }

        public int getAttempts() {
            return attempts;
        }

        public List<Integer> getComputerNumbers() {
            return computerNumbers;
        }
    }