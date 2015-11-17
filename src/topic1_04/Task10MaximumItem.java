package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 09.11.2015.
 * <p>
 * 3.10 Максимальный элемент
 * <p>
 * В функции main() проинициализировать двумерный массив размерностью m x n
 * вещественных чисел. Создать функцию, которая принимает в качестве параметра
 * массив, находит максимальный по модулю элемент массива и возвращает найденное
 * значение. Результат вывести на экран.
 */
public class Task10MaximumItem {
    public static void main(String[] args) {
        double[][] array = new double[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextDouble(-10, 10 + 1);
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println(method(array) + "eeee");
    }

    private static double method(double[][] array) {
        double a = 0;
        for (double i[] : array) {
            for (double j : i) {
                System.out.println(j + " 8**");
                if (Math.abs(j) > a) {
                    a = Math.abs(j);
                }
            }
        }
        return a;
    }
}
