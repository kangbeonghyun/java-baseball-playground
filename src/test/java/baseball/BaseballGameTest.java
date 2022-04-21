package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.BaseballGame.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @BeforeEach
    void setUp() {
    }

    // 정답은 따로 기능으로 빼지 않고 랜덤함수 쓰자.
//    void makeAnswerTest() {
//        String result = makeAnswer();
//        assertThat(11).
//    }

   // 숫자 3개를 입력받는 것도. 굳이..?

    // 갑자기 생겨난 질문.. 테스트를 먼저 작성하니 그럼 프로덕트 코드는 항상 퍼블릭으로 해야하나.
    //3,4 번을 묶어서 비교해서 결과 내는 기능
//    @DisplayName("인풋과 결과의 비교결과를 스트링으로 리턴함")
//    @ParameterizedTest
//    @ValueSource(strings = {"123","145","671","216","713"})
//    void compareTest(String input) {
//
//
//    }

    //스트라이크인지, 볼인지 , 낫싱인지 체크하는 기능이 있어야겠네

    @DisplayName("인풋과 결과를 비교해 스트라이크 개수를 리턴함")
    @ParameterizedTest
    @CsvSource(value = {"123:1","145:0","671:0","216:1","713:3"}, delimiterString = ":")
    void strikeTest(String input, String resultStrikeCount) {
        String result = "713";
        int strikeCount = strike(result, input);
        assertThat(strikeCount).isEqualTo(Integer.parseInt(resultStrikeCount));
    }

    @DisplayName("인풋과 결과를 비교해 볼 개수를 리턴함")
    @ParameterizedTest
    @CsvSource(value = {"123:1","145:1","671:2","216:0","713:0"}, delimiterString = ":")
    void ballTest(String input, String resultStrikeCount) {
        String result = "713";
        int ballCount = ball(result, input);
        assertThat(ballCount).isEqualTo(Integer.parseInt(resultStrikeCount));

    }

    @DisplayName("게임결과를 화면에 출력한다")
    @Test
    void printTest() {
        int strikeCount = 1;
        int ballCount = 2;

        String result = print(strikeCount, ballCount);
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

// 이렇게 생각해서 구현하려고 보니 printAndCheck가 낫다.
//    //3 스트라이크 이면 종료 또는 계속 선택, 아니면 강제 계속
//    @DisplayName("3 스트라이크일 경우 게임 종료 또는 재시작 할 수 있는 플래그가 잘 나오는지")
//    @ParameterizedTest
//    @CsvSource(value = {"1:true","2:false"}, delimiterString = ":")
//    void stopOrContinueTest(String input, boolean isContinue) {
//        //given
//        String result = "3 스트라이크";
//
//        //when
//        boolean flag = stopOrContinue(result, input);
//
//        //then
//        assertThat(flag).isEqualTo(isContinue);
//    }

    //3 스트라이크 이면 종료 또는 계속 선택, 아니면 강제 계속
    @DisplayName("인풋에 따라 게임 종료 또는 재시작 할 수 있는 플래그가 잘 나오는지")
    @ParameterizedTest
    @CsvSource(value = {"3 스트라이크:1:true","3 스트라이크:2:false","1볼::false"}, delimiterString = ":")
    void stopOrContinueTest(String result, String input, boolean isContinue) {

        //when
        boolean flag = printAndCheck(result);

        // 인풋을 모킹할 수 있나..? .. 메소드를 입력과 체킹을 분리하는 게 맞는 거 같기도..

        //then
        assertThat(flag).isEqualTo(isContinue);
    }







}