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
    private static final long[] array = new long[92];
    private static int countarray;
    private static int end = 0;

    public static void main(String[] args) {
        insert();
        math(countarray);
        System.out.println(Arrays.toString(array));

        insert();
        math(countarray);
        System.out.println(Arrays.toString(array));
    }

    private static void insert() {
        System.out.println("Insert Fibonacci number");
        Scanner s = new Scanner(System.in);
        countarray = s.nextInt();
    }

    private static void math(int a) {
        if (end == 0) {
            for (int i = 0; i < a; i++) {
                if (i == 0 || i == 1) {
                    array[i] = 1;
                } else {
                    array[i] = array[i - 2] + array[i - 1];
                }
                end = a;
            }
        } else {
            if (end < a) {
                for (int i = end; i < a; i++) {
                    if (i == 0 || i == 1) {
                        array[i] = 1;
                    } else {
                        array[i] = array[i - 2] + array[i - 1];
                    }
                }
                end = a;
            } else {
                if (end > a) {
                    for (int i = a; i < end; i++) {
                        array[i] = 0;
                    }
                    end = a;
                }
            }
        }
    }
}
