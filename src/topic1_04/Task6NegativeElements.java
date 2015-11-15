package topic1_04;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by GrinWey on 1/8/2016.
 * <p>
 * 3.6 Отрицательные элементы*
 * В функции main() проинициализировать одномерный массив вещественных
 * чисел случайными значениями в диапазоне от -100 до 100. Создать функцию,
 * которая принимает в качестве параметра массив, находит количество
 * отрицательных элементов этого массива, создает новый массив необходимой
 * размерности, заполняет его отрицательными элементами и возвращает новый массив.
 * Результат вывести на экран.
 */
public class Task6NegativeElements {
    public static void main(String[] args) {
        double[] a = new double[10];
        Random rundom = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = rundom.nextDouble() * (100 - (-100)) - 100;//rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(method(a)));
    }

    public static double[] method(double[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                count++;
            }
        }
        double[] b = new double[count];
        int bcount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                b[bcount] = a[i];
                bcount++;
            }
        }
        return b;
    }
}
