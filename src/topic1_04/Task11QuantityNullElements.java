package topic1_04;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by GrinWey on 11/10/2015.
 * <p>
 * 3.11 Количество нулевых элементов
 * В функции main() проинициализировать двумерный массив размерностью m x n вещественных чисел.
 * Создать функцию, которая принимает в качестве параметра массив, определяет, сколько раз в
 * этом массиве встречается элемент со значением 0 и возвращает это количество.
 * Результат вывести на экран.
 */
public class Task11QuantityNullElements {
    public static void main(String[] args) {
        double[][] array = new double[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextDouble(-10, 10 + 1);
            }
        }
        System.out.println((method(array)));
    }

    private static double method(double[][] array) {
        double a = 0;
        for (double i[] : array) {
            for (double j : i) {
                if (j == 0) {
                    a++;
                }
            }
        }
        return a;
    }
}
