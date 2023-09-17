package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Application {

    public static List<Integer> computerNumberList = new ArrayList<>(); // 컴퓨터(정답) 숫자 리스트
    public static int status = 1;   // 1 = 실행, 2 = 중단

    public static void main(String[] args) {
        /*
         * 클래스 객체 생성
         */
        GeneratedRandomValue makeComputerNumber = new GeneratedRandomValue();   // 랜덤값 생성 클래스
        StartGame go = new StartGame();

        /*
         * 게임 시작
         */
        System.out.println("숫자 야구 게임을 시작합니다.");  // 야구게임 시작 문구 출력

        while(status == 1) {    // 게임 한 사이클 진행
            computerNumberList = makeComputerNumber.generateRandomList();    // 랜덤 숫자 생성
            status = go.gaming(computerNumberList);
        }
    }

    /**
     * 랜덤값 생성 클래스
     */
    static class GeneratedRandomValue {
        /*
         * 1~9 값을 갖고 서로 다른 세개의 숫자를 포함한 리스트를 반환하는 메소드
         */
        public List<Integer> generateRandomList() {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < Input.SIZE.getValue()) {
                int randomNumber = Randoms.pickNumberInRange(Input.START.getValue(), Input.END.getValue());
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            return computer;
        }
    }

}
