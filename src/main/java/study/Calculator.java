package study;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] value = values.split(" ");

        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < value.length; i++) {
            deque.add(value[i]);
        }

        while (deque.size() != 1) {
            if(deque.size()<3){
                break;
            }

            int a = Integer.parseInt(deque.removeFirst());
            String operation = deque.removeFirst();
            int b = Integer.parseInt(deque.removeFirst());


            int result  =0;

            if ("+".equals(operation)) {
                result = plus(a,b);
            } else if ("-".equals(operation)) {
                result = minus(a,b);
            } else if ("*".equals(operation)) {
                result = multi(a,b);
            } else {
                result = div(a,b);
            }

            deque.addFirst(String.valueOf(result));
        }

        System.out.println("result = " + deque.getFirst());

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
