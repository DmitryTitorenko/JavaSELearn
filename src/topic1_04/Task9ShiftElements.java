package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 09.11.2015.
 * <p>
 * 3.9 Сдвиг элементов
 * В функции main() проинициализировать одномерный массив целых чисел. Создать функцию,
 * которая принимает в качестве параметра массив, находит нулевой элемент массива
 * (элементс индексом 0), переносит его на последнее место, сдвинув влево все стоящие
 * за ним элементы. Вывести полученный массив на экран.
 */
public class Task9ShiftElements {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-10, 10 + 1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(method(array)));
    }

    private static int[] method(int[] array) {
        int a = array[0];

        for (int i = 0; i < array.length; i++) {
            if(i!=array.length-1)
            {
                array[i] = array[i + 1];
            }
        }
        array[array.length - 1] = a;
        return array;
    }
}
