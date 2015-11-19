package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 *
 * Реализовать и протестировать функцию, которая вычисляет π с точностью до заданного ε по следующей формуле.
 * Параметром функции должна быть точность (ε). Вычисление должно прекращаться,
 * если очередное слагаемое меньше ε по абсолютной величине.
 * Реализовать два варианта - с использованием цикла и с использованием рекурсии.
 */
public class Task21 {
    private static double p = 3;
    private static double a1 = 2;
    private static double a2 = 3;
    private static double a3 = 4;
    private static double e = 4 / (a1 * a2 * a3);//слагаемое
    private static boolean eee = true;

    public static void main(String[] args) {

        System.out.println("Введите точность ");
        double c = new Scanner(System.in).nextDouble();//точноть

        while (e > c) {
            if (eee) {
                e = 4 / (a1 * a2 * a3);
                p += e;
                a1 += 2;
                a2 += 2;
                a3 += 2;
                eee = false;
            } else {
                e = 4 / (a1 * a2 * a3);
                p -= e;
                a1 += 2;
                a2 += 2;
                a3 += 2;
                eee = true;
            }
        }
        System.out.printf("Наименьшее слогаемое:" + e + "%n\u03C0:" + p);
    }
}
