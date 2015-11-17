package topic1_04;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Dmitry Titorenko on 08.11.2015.
 * <p>
 * Упорядочивание элементов*
 * В функции main() проинициализировать одномерный массив из 10 целых чисел.
 * Создать функцию, которая принимает в качестве параметра массив, упорядочивает первые
 * 4 элемента этого массива по возрастанию, последние 4 – по убыванию. Результат вывести на экран.
 */
public class Task7OrganizeItems {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        method(array);
    }

    private static Integer[] method(Integer[] a) {
        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = -10 + random.nextInt(10 - (-10) + 1);//from + rndGenerator.nextInt(to - from + 1)
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, 0, 5);
        System.out.println(Arrays.toString(a));

        Arrays.sort(a, 5, 10, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));

        return a;
    }
}
