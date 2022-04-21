package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Random random = new Random();

        //여기도 메소드로 따로 뺐어야 했네.
        String one = String.valueOf(random.nextInt(9));
        while (one.equals("0")) {
            one = String.valueOf(random.nextInt(9));
        }

        String two = String.valueOf(random.nextInt(9));
        while (one.equals(two) || two.equals("0")) {
            two = String.valueOf(random.nextInt(9));
        }
        String three = String.valueOf(random.nextInt(9));

        while (one.equals(three) || two.equals(three) || three.equals("0")) {
            three = String.valueOf(random.nextInt(9));
        }


        String answer = one + two + three;
        System.out.println("answer = " + answer);



        int strikeCount = 0;
        int ballCount = 0;
        boolean isContinue = true;

        String result;

        while (isContinue) {
            System.out.println("숫자를 입력하시오: ");
            String input = scanner.nextLine();

            strikeCount = strike(answer, input);
            ballCount = ball(answer, input);
            result = print(strikeCount, ballCount);
            isContinue = printAndCheck(result);
        }
    }

    public static boolean printAndCheck(String result) {
        System.out.println("result = " + result);
        if (!"3스트라이크".equals(result)) {
            return true;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = scanner.nextLine();

        if("1".equals(input)) {
            return true;
        }

        return false;
    }

    public static int strike(String result, String input) {
        int strikeCount = 0;

        for (int i = 0; i < 3; ++i) {
            if (result.charAt(i) == input.charAt(i)) {
                strikeCount++;
            }
        }
//        if (result.charAt(0) == input.charAt(0)) {
//            strikeCount++;
//        }
//
//        if (result.charAt(1) == input.charAt(1)) {
//            strikeCount++;
//        }
//
//        if (result.charAt(2) == input.charAt(2)) {
//            strikeCount++;
//        }
        return strikeCount;
    }

    public static int ball(String result, String input) {
        int ballCount = 0;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if(i == j) continue;
                if (result.charAt(i) == input.charAt(j)) {
                    ballCount++;
                }
            }

        }
        return ballCount;
    }

    public static String print(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }

        if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        if (strikeCount == 0 && ballCount > 0) {
            return ballCount + "볼";
        }

        return "낫싱";
    }
}
