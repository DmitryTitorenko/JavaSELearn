package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 02.11.2015.
 *
 * Ввести значение eps и найти сумму ряда
 * y = 1 + 1/2 + 1/4 + 1/8 + 1/16 + ...
 * Добавлять слагаемые до тех пор, пока очередное слагаемое не станет меньше eps.
 */
public class Task10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("inser eps");
        double eps = s.nextDouble();
        double y = 0;
        double i;
        double a;
        for (i = 1, a = 1; a >= eps; i *= 2) {
            y += 1 / i;
            a = 1 / i;
            System.out.println("y:" + y + " слогаемое:" + a);
        }
    }
}