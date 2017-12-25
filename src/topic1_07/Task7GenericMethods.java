package topic1_07;

/*
3.7 Библиотека обобщенных функций*

Создать класс, который содержит обобщенные статические функции для реализации следующих действий с массивом:

    -обмена значениями двух элементов массива с индексами, которые передаются в качестве параметров
    -изменения порядка элементов на противоположный
    -определения количества раз вхождения определенного элемента в массив

Осуществить тестирование всех функций на двух массивах различных типов.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Task7GenericMethods {
    public static void main(String[] args) {
        testSwitchIndex();
        testSwitchSequence();
        testCountElement();
    }

    private static void testSwitchIndex() {
        Integer[] array1 = new Integer[2];
        Integer[] array2 = new Integer[2];
        array1[0] = 0;
        array1[1] = 0;
        array2[0] = 1;
        array2[1] = 1;

        ArrayList a = GenericMethod.switchIndex(array1, 0, array2, 0);
        array1 = (Integer[]) a.get(0);
        array2 = (Integer[]) a.get(1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private static void testSwitchSequence() {
        Integer[] array1 = new Integer[2];
        Integer[] array2 = new Integer[2];
        array1[0] = 1;
        array1[1] = 2;
        array2[0] = 1;
        array2[1] = 2;

        ArrayList a = GenericMethod.switchSequence(array1, array2);
        array1 = (Integer[]) a.get(0);
        array2 = (Integer[]) a.get(1);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private static void testCountElement(){
        Integer[] array1 = new Integer[4];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 1;
        array1[3] = 2;

        System.out.println( GenericMethod.countElement(array1, 1));
    }
}


class GenericMethod {
    public static <T> ArrayList<T[]> switchIndex(T[] array1, int index1, T[] array2, int index2) {
        Object temp = array1[index1];
        array1[index1] = array2[index2];
        array2[index2] = (T) temp;

        ArrayList<T[]> ts = new ArrayList<>();
        ts.add(array1);
        ts.add(array2);
        return ts;
    }

    public static <T> ArrayList<T[]> switchSequence(T[] array1, T[] array2) {
        Object temp;
        for (int i = 0; i < array1.length / 2; i++) {
            temp = array1[i];
            array1[i] = array1[array1.length - 1];
            array1[array1.length - 1] = (T) temp;
        }
        for (int i = 0; i < array2.length / 2; i++) {
            temp = array2[i];
            array2[i] = array2[array2.length - 1];
            array2[array2.length - 1] = (T) temp;
        }

        ArrayList<T[]> ts = new ArrayList<>();
        ts.add(array1);
        ts.add(array2);
        return ts;
    }

    public static <T> int countElement(T[] array, T element) {
        int count = 0;
        for (T anArray : array) {
            if (anArray.equals(element)) {
                count++;
            }
        }
        return count;
    }
}

