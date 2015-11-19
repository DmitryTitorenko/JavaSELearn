package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 * <p>
 * Реализовать программу вычисления факториала с помощью рекурсивной функции.
 */
public class Task18 {
    private static int c = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int d = s.nextInt();
        int b = recursion(d);
        System.out.println(b);
    }

    private static int recursion(int a) {
        if (a <= 0) {
            return c;
        } else {
            c *= a;
            a--;
            if (a != 0) {
                recursion(a);
            }
        }
        return c;
    }
}
