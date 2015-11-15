package topic1_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 07.11.2015.
 * <p>
 * 3.4 Обратный порядок
 * Проинициализировать одномерный массив вещественных чисел списком начальных значений,
 * изменить порядок следования элементов на противоположный и вывести элементы массива на экран.
 */
public class Task4ReverseOrder {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        double first;
        double last;
        System.out.println("Введите размерность массива");
        double[] a = new double[s.nextInt()];
        System.out.println("Введите элементы массива");

        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextDouble();
        }

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length / 2; i++) {
            first = a[i];
            last = a[a.length - 1 - i];
            a[i] = last;
            a[a.length - 1 - i] = first;
        }

        System.out.println(Arrays.toString(a));
    }
}
