package topic1_04;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 06.11.2015.
 * Ввести элементы одномерного массива вещественных чисел с клавиатуры.
 * Найти сумму максимального и минимального элементов массива.
 */
public class Task2SumOfMaxAndMinElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите размерность массива");
        double[] a = new double[s.nextInt()];
        System.out.println("Введите элементы");
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextDouble();
        }
        double maxsum = a[0];
        double minsum = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < minsum) {
                minsum = a[i];
            }
            if (a[i] > maxsum) {
                maxsum = a[i];
            }
        }
        double allsum = maxsum + minsum;
        System.out.printf("min" + minsum + "%nmax" + maxsum + "%nsum" + allsum);
    }
}
