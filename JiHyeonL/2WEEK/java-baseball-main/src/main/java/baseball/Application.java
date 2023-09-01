package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    enum Input {
        SIZE(3),
        START(1),
        END(9),
        CONTINUE(1),
        EXIT(2);
        private int value;

        Input(int value) {
            this.value = value;
        }
    }
    public static List<Integer> computerNumberList = new ArrayList<>();
    public static List<Integer> userNumberList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RequestToUser getInputForUser = new RequestToUser();
        GeneratedRandomValue makeComputerNumber = new GeneratedRandomValue();

        makeComputerNumber.generateRandomList(computerNumberList);    // 랜덤 숫자 생성
        getInputForUser.printStartSentence();   // 야구게임 시작 안내문
        getInputForUser.requestNumberToUser(userNumberList);  // 유저에게 숫자 3개 받기
        System.out.println(userNumberList.toString());

    }

    /**
     * 랜덤값 생성 클래스
     */
    static class GeneratedRandomValue {
        /*
         * 1~9 값을 갖고 서로 다른 세개의 숫자를 포함한 리스트를 반환하는 메소드
         */
        public List<Integer> generateRandomList(List<Integer> computer) {

            while (computer.size() < Input.SIZE.value) {
                int randomNumber = Randoms.pickNumberInRange(Input.START.value, Input.END.value);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            return computer;
        }
    }

    /**
     * 입력값 클래스
     */
    static class RequestToUser {
        /*
         * 시작 문구를 출력하는 메소드
         */
        public void printStartSentence() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        /*
         * 숫자 입력 문구와 함께 입력을 받는 메소드
         */
        public List<Integer> requestNumberToUser(List<Integer> numberList) {
            System.out.print("숫자를 입력해주세요 : ");
            for(int i = 0; i < Input.SIZE.value; i++) {
                numberList.add(Integer.parseInt(Console.readLine()));
            }
            return numberList;
        }
        /*
         * 정답을 맞혀 게임 종료 문구와 함께 새로 시작(1) 이나 종료(2) 입력을 받는 메소드
         */
        public int printCompleteAndGetNextStatus() {
            System.out.println("n개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            return Integer.parseInt(Console.readLine());
        }
    }

    /**
     * 입력 예외처리 클래스
     */
    static class Invalid {
        /*
         * 숫자를 세 개 입력했는지 확인하는 메소드
         */
        public void inputListSizeInRange(List<Integer> userList) {
            if (userList.size() != Input.SIZE.value)
                throw new IllegalArgumentException("입력 오류: 입력하신 숫자들의 개수가 "+Input.SIZE.value+"이(가) 아닙니다.");
        }
        /*
         * 게임 플레이어가 1~9 사이의 숫자를 입력했는지 확인하는 메소드
         */
        public void inputInRange(List<Integer> userList) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i) < Input.START.value && userList.get(i) > Input.END.value)
                    throw new IllegalArgumentException("입력 오류: 숫자가 "+Input.START.value+" ~ "+Input.END.value+"사이에 있지 않습니다.");
            }
        }
        /*
         * 서로 다른 숫자 세개를 입력했는지 확인하는 메소드
         */
        public void inputIsUnique(List<Integer> userList) {
            for (int i = 0; i < userList.size()-1; i++) {
                if (userList.get(i) == userList.get(i+1))
                    throw new IllegalArgumentException("입력 오류: 입력한 숫자 중 서로 같은 숫자가 존재합니다.");
            }
        }
        /*
         * 게임이 종료된 뒤 재시작/종료를 구분하는 1과 2중 하나의 숫자를 입력했는지 확인하는 메소드
         */
        public int inputIsStartOrEnd(int endAfter) {
            if(endAfter != Input.CONTINUE.value || endAfter != Input.EXIT.value)
                throw new IllegalArgumentException("입력 오류: 재시작("+Input.CONTINUE.value+")이나 종료("+Input.EXIT.value+")가 아닌 다른 숫자를 입력하였습니다.");
            return endAfter;
        }
    }

    /**
     * 결과값 클래스
     */
    static class ComputerOutput {
        public void printResultUsingHint() {

        }
        public void hintOfNumber() {

        }

    }
}
