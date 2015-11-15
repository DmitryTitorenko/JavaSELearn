package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 09.11.2015.
 * <p>
 * 3.8 Среднее арифметическое
 * В функции main() проинициализировать одномерный массив целых чисел. Создать функцию,
 * которая принимает в качестве параметра массив и находит среднее арифметическое всех
 * чётных элементов массива, стоящих на нечётных местах (с нечетными индексами).
 * Результат вывести на экран.
 */
public class Task8ArithmeticAverage {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-10, 10 + 1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(method(array));
    }

    public static int method(int[] array) {
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && (i & 1) != 0) {//остаток от деления и побитовое сравнение
                a += array[i];
            }//помни что отчет в массиве начинается с 0
        }
        return a;
    }
}
