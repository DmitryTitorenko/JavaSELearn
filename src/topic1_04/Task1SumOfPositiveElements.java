package topic1_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 05.11.2015.
 * 3.1 Сумма положительных элементов*
 * <p>
 * Проинициализировать одномерный массив вещественных чисел списком начальных значений.
 * Найти сумму положительных элементов. Реализовать два варианта – с циклом и с рекурсией.
 */
public class Task1SumOfPositiveElements {
    public static void main(String[] args) {
        System.out.println("Введите размерность массива");
        Scanner s = new Scanner(System.in);
        double[] a = new double[s.nextInt()];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                sum += a[i];
            }
        }
        System.out.printf(Arrays.toString(a) + "%n" + sum);
    }
}

