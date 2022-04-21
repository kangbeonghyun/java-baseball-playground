package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest1() {
        String[] resultArr = "1,2".split(",");
        assertThat(resultArr).containsExactly("1","2");
    }

    @Test
    void splitTest2() {
        String[] resultArr = "1,".split(",");
        assertThat(resultArr).containsExactly("1");
    }

    @Test
    void subStringTest() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String.charAt() 태스트, 인덱스가 맞지 않으면 StringIndexOutOfBoundsException 발생")
    @Test
    void charAtTest() {
        assertThatThrownBy(() -> {
            char resultChar = "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
