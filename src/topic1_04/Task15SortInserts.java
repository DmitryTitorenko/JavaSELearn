package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 17.11.2015.
 * <p>
 * Сортировка вставками
 * В функции main() проинициализировать одномерный массив целых чисел.
 * Создать функцию, которая осуществляет упорядочение массива методом сортировки вставками.
 * Алгоритм заключается в следующем:
 * 1. перебираем все элементы массива по очереди;
 * 2. выбираем очередной элемент массива, сдвигаем, если нужно, элемент влево, пока он не окажется на нужной позиции
 * (при этом элементы, стоящие между первоначальной и окончательной позициями данного элемента, сдвигаются вправо);
 * 3. продолжаем до тех пор, пока не переберем все элементы массива.
 */
public class Task15SortInserts {

    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        System.out.println(Arrays.toString(array));
        sortSelect(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortSelect(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int step = array[j - 1];
                array[j - 1] = array[j];
                array[j] = step;
            }
        }
    }
}
