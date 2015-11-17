package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 12.11.2015.
 * <p>
 * Эратосфеново решето
 * Заполнить массив из трехсот целых чисел последовательными положительными значениями.
 * Заменить все значения, не являющиеся простыми числами, некоторым отрицательным значением.
 * Для этого последовательно исключать все числа – делители других чисел
 * (для 2 – 4, 6, 8..., для 3 – 9, 15, 21... и т.д.).
 * Вывести на экран оставшиеся положительные значения (простые числа).
 */
public class Task13SieveOfEratosthenes {

    private static double[] array = new double[300];

    public static void main(String[] args) {
        arrayInitialization(array);
        System.out.println(Arrays.toString(array));
        searchSimpleNumbers(array);
        System.out.println(Arrays.toString(array));
        output(array);
    }

    private static void arrayInitialization(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private static void searchSimpleNumbers(double[] array) {
        for (int i = 2; i < array.length; i++) {
            for (int j = i * i; j < array.length; j++) {
                if (array[j] % i == 0) {
                    array[j] = ThreadLocalRandom.current().nextInt(-10, 0);
                }
            }
        }
    }

    private static void output(double[] array) {
        for (double a : array) {
            if (a > 0) {
                System.out.print(" " + a);
            }
        }
    }
}
