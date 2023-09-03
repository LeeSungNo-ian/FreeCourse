package baseball;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest extends NsTest {
    @Test
    void 낫싱() {
        Ball ball = new Ball(0, '3');
        Computer computer = new Computer(new Balls("517"));
        assertThat(computer.findBallStatus(ball)).isEqualTo("NOTHING");
    }

    @Test
    void 볼() {
        Ball ball = new Ball(0, '3');
        Computer computer = new Computer(new Balls("531"));
        assertThat(computer.findBallStatus(ball)).isEqualTo("BALL");
    }

    @Test
    void 스트라이크() {
        // given
        Ball ball = new Ball(0, '3');
        Computer computer = new Computer(new Balls("357"));

        // when
        String ballStatus = computer.findBallStatus(ball);

        // then
        assertThat(ballStatus).isEqualTo("STRIKE");
    }

    @Test
    void 쓰리스트라이크() {
        // given
        Balls input = new Balls("537");
        Computer computer = new Computer(new Balls("537"));

        // when
        Result result = computer.calculate(input);

        // then
        assertThat(result.strikeNum).isEqualTo(3);
    }

    @Test
    void 투볼_원스트라이크() {
        // given
        Balls input = new Balls("357");
        Computer computer = new Computer(new Balls("537"));

        // when
        Result result = computer.calculate(input);

        // then
        assertThat(result.strikeNum).isEqualTo(1);
        assertThat(result.ballNum).isEqualTo(2);
    }

    @Test
    void _낫싱() {
        // given
        Balls input = new Balls("357");
        Computer computer = new Computer(new Balls("148"));

        // when
        Result result = computer.calculate(input);

        // then
        assertThat(result.strikeNum).isEqualTo(0);
        assertThat(result.ballNum).isEqualTo(0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
