package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 11.11.2015.
 * <p>
 * 3.12 Максимальный из минимальных
 * В функции main() проинициализировать двумерный массив размерностью m x n целых чисел.
 * Создать функцию, которая принимает в качестве параметра массив, находит максимальный
 * элемент из минимальных элементов строк массива и возвращает его. Результат вывести на экран.
 */
public class Task12MaxOfMin {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(-10, 11);
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("Max of array: " + method(array));
    }

    public static int method(int[][] array) {
        int a[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < a[i]) {
                    a[i] = array[i][j];
                }
            }
        }
        System.out.println("Min from each row: " + Arrays.toString(a));
        int b = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b) {
                b = a[i];
            }
        }
        return b;
    }
}

