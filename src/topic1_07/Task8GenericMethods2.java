package topic1_07;

/*
3.8 Библиотека функций для работы с массивом чисел*

Создать класс, который содержит статические обобщенные функции для реализации следующих действий с массивом чисел:

    - нахождение индекса первого нулевого элемента
    - определение количества отрицательных чисел
    - возвращение последнего отрицательного элемента

Осуществить тестирование всех функций на числовых массивах различных типов.
 */

public class Task8GenericMethods2 {
    public static void main(String[] args) {
        testFindFirstNull();
    }

    private static void testFindFirstNull() {
        Integer[] array = new Integer[4];
        array[0] = 1;
        array[1] = 0;
        array[2] = -1;
        array[3] = -3;
        System.out.println(GenericMethods2.findFirsNull(array));

        System.out.println(GenericMethods2.countNegativeValue(array));

        System.out.println(GenericMethods2.getLastNegativeValue(array));
    }
}

class GenericMethods2 {
    public static <T extends Number> int findFirsNull(T[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(0)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static <T extends Number> int countNegativeValue(T[] array) {
        int countNegativeValue = 0;
        for (T t : array) {
            if (t.intValue() < 0) {
                countNegativeValue++;
            }
        }
        return countNegativeValue;
    }

    public static <T extends Number> T getLastNegativeValue(T[] array) {
        T lastNegativeValue = null;
        for (int i = array.length - 1; i >= 0; i++) {
            if (array[i].intValue() < 0) {
                lastNegativeValue = array[i];
                break;
            }
        }
        return lastNegativeValue;
    }
}
