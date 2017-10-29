package topic1_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 18.11.2015.
 * <p>
 * Вычисление чисел Фибоначчи
 * Реализовать функцию вычисления чисел Фибоначчи (до 92-го числа включительно)
 * с использованием вспомогательного массива (статического поля).
 * Параметр функции – номер числа Фибоначчи. При первом вызове функции массив заполняется до необходимого числа.
 * При последующих вызовах число либо возвращается из массива,
 * либо вычисляется с использованием последних двух чисел, хранящихся в массиве с дальнейшим заполнением массива.
 * Использовать тип long для представления чисел.
 */
public class Task16FibonacciNumber {
    private static long[] array = new long[92];
    private static int maxArrayIndex = 0;

    public static void main(String[] args) {
        System.out.println(fibonacciNumber(10));
        System.out.println(Arrays.toString(array));

        System.out.println(fibonacciNumber(6));
        System.out.println(Arrays.toString(array));

        System.out.println(fibonacciNumber(15));
        System.out.println(Arrays.toString(array));
    }


    private static long fibonacciNumber(int count) {
        if (maxArrayIndex == 0) {
            array[0] = 1;
            array[1] = 1;
            for (int i = 2; i < count; i++) {
                array[i] = array[i - 2] + array[i - 1];
            }
            maxArrayIndex = count;
            return array[count - 1];
        } else if (count > maxArrayIndex) {
            for (int i = maxArrayIndex - 1; i < count; i++) {
                array[i] = array[i - 2] + array[i - 1];
            }
            maxArrayIndex = count;
            return array[count - 1];
        } else if (count < maxArrayIndex) {
            return array[count - 1];
        }
        return 0;
    }
}