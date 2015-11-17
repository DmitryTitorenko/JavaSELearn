package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 17.11.2015.
 * <p>
 * Сортировка выбором
 * Проинициализировать одномерный массив целых чисел случайными значениями.
 * Осуществить упорядочение массива методом сортировки выбором. Алгоритм заключается в следующем:
 * 1. находим номер минимального значения в текущем списке;
 * 2. производим обмен этого значения со значением первой неотсортированной позиции
 * (обмен не нужен, если минимальный элемент уже находится на данной позиции);
 * 3. сортируем хвост списка, исключив из рассмотрения уже отсортированные элементы.
 * Результат вывести на экран.
 */
public class Task14SortSelection {

    public static void main(String[] args) {
        int[] array = determinationArray();
        System.out.println(Arrays.toString(array));
        array = sortSelection(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] determinationArray() {
        int length = 5;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        return array;
    }

    private static int[] sortSelection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean end = true;
            int min = array[i];
            int index = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    index = j;
                    min = array[j];
                    end = false;
                }
            }
            if (!end) {
                array[index] = array[i];
                array[i] = min;
            }
        }
        return array;
    }
}
