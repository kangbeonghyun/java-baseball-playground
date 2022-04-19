package study;


import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] value = values.split(" ");





        for (int i = 1; i < value.length; i++) {
            int a = Integer.parseInt(value[i-1]);
            int b = Integer.parseInt(value[i+1]);
            int result = 0;
            if ("+".equals(value[i])) {
                plus(a, b);
            }

            if ("-".equals(value[i])) {
                minus(a, b);
            }

            if ("*".equals(value[i])) {
                multi(a, b);
            }

            if ("/".equals(value[i])) {
                div(a, b);
            }

        }

    }

    public static int div(int a, int b) {
        return a/b;
    }

    public static int multi(int a, int b) {
        return a*b;
    }

    public static int minus(int a, int b) {
        return a-b;
    }

    public static int plus(int a, int b) {
        return a+b;
    }

}
