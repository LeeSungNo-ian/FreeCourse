package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class StartGame {

    public static List<Integer> userNumberList = new ArrayList<>(); // 유저 input 숫자 리스트
    public static String userNumbers = "";  // input 담을 변수
    public static StringBuilder hintOutput;   // input의 hint 결과
    public static int gameStatus = 1;   // 1 = 실행, 2 = 중단

    public int gaming(List<Integer> computer) {
        /*
         * 클래스 객체 생성
         */
        RequestToUser userInput = new RequestToUser();   // 입력값을 받는 클래스
        Invalid checkInputIsValid = new Invalid();  // 입력 예외처리 클래스
        StringConvert inputToList = new StringConvert();    // 입력값을 int list로 변환하는 클래스
        ComputerOutput hintForUser = new ComputerOutput();  // 결과값(힌트) 클래스

        while (gameStatus == 1) {
            userNumbers = userInput.requestNumberToUser();  // 유저에게 숫자 3개 받기
            hintOutput = new StringBuilder(); // output 초기화
            System.out.println(userNumbers);

            checkInputIsValid.inputListSizeInRange(userNumbers); // 입력이 3개인지 체크
            checkInputIsValid.inputInRange(userNumbers); // 입력이 1~9의 숫자인지 체크
            checkInputIsValid.inputIsUnique(userNumbers);    // 입력이 각자 다른지 체크

            userNumberList = inputToList.strNumToIntList(userNumbers);  // 입력이 올바른 형태일 때 int list 형태로 변환

            boolean isNothing = hintForUser.returnNothingExist(userNumberList,computer);
            int ballCount = hintForUser.returnBallCount(userNumberList,computer);
            int strikeCount = hintForUser.returnStrikeCount(userNumberList,computer);

            if (isNothing) {   // 낫싱이라면 낫싱을 hintOutput에 더하기
                hintOutput.append(Hint.NOTHING.getValue());
            }
            if (ballCount > 0) {// 볼이 존재한다면 count+볼을 hintOutput에 더하기
                hintOutput.append(hintForUser.returnBallCount(userNumberList,computer));
                hintOutput.append(Hint.BALL.getValue());
                hintOutput.append(" ");
            }
            if (strikeCount > 0) {// 스트라이크가 존재한다면 count+스트라이크를 hintOutput에 더하기
                hintOutput.append(hintForUser.returnStrikeCount(userNumberList,computer));
                hintOutput.append(Hint.STRIKE.getValue());
                hintOutput.append(" ");
            }

            System.out.println(hintOutput.toString());   // 힌트 결과 출력

            if (hintForUser.returnStrikeCount(userNumberList,computer) == Input.SIZE.getValue()) {  // 모든 숫자를 맞추면 재시작 or 게임 종료
                System.out.println(Input.SIZE.getValue()+"개의 숫자를 모두 맞히셨습니다! 게임 종료");   // 종료 문구 출력
                String strStatus =  userInput.printCompleteAndGetNextStatus(); // 재시작 or 게임 종료 물어보기

                checkInputIsValid.inputIsStartOrEnd(strStatus);  // 올바른 입력인지 체크
                break;
            }

        }
        return gameStatus;
    }

    /**
     * 유저에게 입력값을 받는 클래스
     */
    static class RequestToUser {
        private static String numbers = "";
        /*
         * 숫자 입력 문구와 함께 입력을 받는 메소드
         */
        public String requestNumberToUser() {
            System.out.print("숫자를 입력해주세요 : ");
            numbers = Console.readLine();

            return numbers;
        }
        /*
         * 정답을 맞혀 새로 시작(1) 이나 종료(2) 입력을 받는 메소드
         */
        public String printCompleteAndGetNextStatus() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            return Console.readLine();
        }
    }
    static class Invalid {
        /*
         * 문자를 세 개 입력했는지 확인하는 메소드
         */
        public void inputListSizeInRange(String userInput) {
            if (userInput.length() != Input.SIZE.getValue()) {
                throw new IllegalArgumentException("[입력 오류] 입력하신 숫자의 개수가 " + Input.SIZE.getValue() + "을(를) 넘었습니다.");
            }
        }
        /*
         * 게임 플레이어가 1~9 사이의 숫자를 입력했는지 확인하는 메소드
         */
        public void inputInRange(String userInput) {
            for (int i = 0; i < userInput.length(); i++) {
                if (userInput.charAt(i) < Input.START.getValue() && userInput.charAt(i) > Input.END.getValue())
                    throw new IllegalArgumentException("[입력 오류] 입력하신 내용이 "+Input.START.getValue()+" ~ "+Input.END.getValue()+"사이의 숫자가 아닙니다.");
            }
        }
        /*
         * 서로 다른 숫자 세개를 입력했는지 확인하는 메소드
         */
        public void inputIsUnique(String userInput) {
            for (int i = 0; i < userInput.length()-1; i++) {
                if (userInput.charAt(i) == userInput.charAt(i+1))
                    throw new IllegalArgumentException("[입력 오류] 입력한 숫자 중 서로 같은 숫자가 존재합니다.");
            }
        }
        /*
         * 게임이 종료된 뒤 재시작/종료를 구분하는 1과 2중 하나의 숫자를 입력했는지 확인하는 메소드
         */
        public void inputIsStartOrEnd(String userInput) {
            if(!userInput.equals(Status.CONTINUE.getValue()) && !userInput.equals(Status.EXIT.getValue())) {
                throw new IllegalArgumentException("[입력 오류] 재시작(" + Status.CONTINUE.getValue() + ")이나 종료(" + Status.EXIT.getValue() + ")가 아닌 다른 숫자를 입력하였습니다.");
            }
        }
    }

    /**
     * 정수 문자열 입력값을 int 리스트로 변환하는 클래스
     */
    static class StringConvert {

        public List<Integer> strNumToIntList(String input) {
            List<Integer> numberList = new ArrayList<>();

            for (int i = 0; i < input.length(); i++) {
                numberList.add(Character.getNumericValue(input.charAt(i)));
            }
            return numberList;
        }
    }

    /**
     * 결과값 클래스
     */
    static class ComputerOutput {
        /*
         * 볼이 존재한다면 몇개의 볼이 존재하는지 cnt를 반환하는 메소드
         */
        public int returnBallCount(List<Integer> numbers, List<Integer> computerNumbers) {
            int count = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (computerNumbers.contains(numbers.get(i)) && i != computerNumbers.indexOf(numbers.get(i))) {
                    count++;
                }
            }
            return count;
        }
        /*
         * 스트라이크가 존재한다면 몇개의 스트라이크가 존재하는지 cnt를 반환하는 메소드
         */
        public int returnStrikeCount(List<Integer> numbers, List<Integer> computerNumbers) {
            int count = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).equals(computerNumbers.get(i))) {
                    count++;
                }
            }
            return count;
        }
        /*
         * 낫싱이라면 true, 아니라면 false 반환
         */
        public boolean returnNothingExist(List<Integer> numbers, List<Integer> computerNumbers) {
            for (int i = 0; i < numbers.size(); i++) {
                if (computerNumbers.contains(numbers.get(i))) {
                    return false;
                }
            }
            return true;
        }

    }
}
