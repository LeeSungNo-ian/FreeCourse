package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
//    interface Game {
//        Rule rule ;
//
//        public abstract void showInterface();
//    }
//
//    interface Rule {
//
//    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        String answer = make();
        System.out.println(answer);

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();

            Result result = method(answer, input);
            if (result.strikeNum != 3) {
                System.out.println(result);
                continue;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String option = Console.readLine();
            if (option.equals("1")) {
                main(new String[]{});
            } else if (option.equals("2")) {
                break;
            }
        }
    }

    private static String make() {
        String result = "";
        while (result.length() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);

            // 중복 검사, 중복되면 다시 랜덤뽑기
            if (result.contains(String.valueOf(random))) {
                continue;
            }

            result += random;
        }
        return result;
    }

    private static Result method(String answer, String input) {
        int strikeNum = 0;
        int ballNum = 0;

        int inputPointer = 0;

        while (inputPointer < input.length()) {
            String result = check(answer, new InputChar(inputPointer, input.charAt(inputPointer)));

            if (result == "STRIKE") {
                strikeNum++;
            } else if (result == "BALL") {
                ballNum++;
            }

            inputPointer++;
        }
        return new Result(strikeNum, ballNum);
    }

    private static String check(String answer, InputChar inputChar) {
        int ansPointer = 0;

        while (ansPointer < answer.length()) {
            if (answer.charAt(ansPointer) == inputChar.c && ansPointer == inputChar.idx) {
                return "STRIKE";
            } else if (answer.charAt(ansPointer) == inputChar.c) {
                return "BALL";
            }
            ansPointer++;
        }

        return "NOTHING";
    }

    static class InputChar {
        int idx;
        char c;

        public InputChar(int idxValue, char cValue) {
            idx = idxValue;
            c = cValue;
        }
    }

    static class Result {
        int strikeNum;
        int ballNum;

        public Result(int strikeNumValue, int ballNumValue) {
            strikeNum = strikeNumValue;
            ballNum = ballNumValue;
        }

        @Override
        public String toString() {
            if (ballNum != 0 && strikeNum != 0) {
                return ballNum + "볼 " + strikeNum + "스트라이크";
            } else if (ballNum != 0) {
                return ballNum + "볼";
            } else if (strikeNum != 0) {
                return strikeNum + "스트라이크";
            }

            return "낫싱";
        }
    }
}
