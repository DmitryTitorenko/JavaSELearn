package topic1_04;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 06.11.2015.
 * 3.1 Сумма положительных элементов*
 * <p>
 * Проинициализировать одномерный массив вещественных чисел списком начальных значений.
 * Найти сумму положительных элементов. Реализовать два варианта – с циклом и с рекурсией.
 */
public class Task1Recursion {
    public static double allsum = 0;
    public static int lenght = 0;
    public static int step = 1;


    public static void main(String[] args) {
        System.out.println("Введите размерность массива");
        Scanner s = new Scanner(System.in);
        double[] a = new double[s.nextInt()];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        sum(a);
        System.out.printf(Arrays.toString(a) + "%n" + allsum);
    }

    public static void sum(double[] a) {
        lenght = a.length - step;
        if (lenght >= 0) {
            if (a[lenght] >= 0) {
                allsum += a[lenght];
                step++;
                sum(a);
            } else {
                step++;
                sum(a);
            }
        }
    }
}
