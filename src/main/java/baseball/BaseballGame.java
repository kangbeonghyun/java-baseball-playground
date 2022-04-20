package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) {
        Random random = new Random();
        String answer = String.valueOf(random.nextInt());

        Scanner scanner = new Scanner(System.in);

        int strikeCount = 0;
        int ballCount = 0;
        String result;

        while (true) {
            System.out.println("숫자를 입력하시오: ");
            String input = scanner.nextLine();

            strikeCount = strike(answer, input);
            ballCount = ball(answer, input);
            result = print(strikeCount, ballCount);

            System.out.println(result);


        }
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
