package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 */
public class Task21recursion {
    private static double p = 3;
    private static double a1 = 2;
    private static double a2 = 3;
    private static double a3 = 4;
    private static double e = 4 / (a1 * a2 * a3);//слагаемое
    private static boolean eee = true;
    private static double c;

    public static void main(String[] args) {

        System.out.println("Введите точность ");
        c = new Scanner(System.in).nextDouble();//точноть
        math();
        System.out.printf("Наименьшее слогаемое:" + e + "%n\u03C0:" + p);
    }

    public static void math() {
        if (e > c) {
            if (eee == true) {
                e = 4 / (a1 * a2 * a3);
                p += e;
                a1 += 2;
                a2 += 2;
                a3 += 2;
                eee = false;
                math();
            } else {
                e = 4 / (a1 * a2 * a3);
                p -= e;
                a1 += 2;
                a2 += 2;
                a3 += 2;
                eee = true;
                math();
            }
        }
    }
}
