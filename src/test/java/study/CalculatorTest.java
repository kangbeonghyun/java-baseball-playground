package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    public Calculator calculator;

    @DisplayName("플러스 메소드에 숫자 두개를 넣으면 더하기를 한다.")
    @Test
    void plusTest() {
        assertThat(calculator.plus(3,4)).isEqualTo(7);
    }

    @Test
    void minusTest() {
        assertThat(calculator.minus(4,3)).isEqualTo(1);
    }

    @Test
    void multiTest() {
        assertThat(calculator.multi(3,4)).isEqualTo(12);
    }

    @Test
    void divTest() {
        assertThat(calculator.div(4,2)).isEqualTo(2);
    }
}
