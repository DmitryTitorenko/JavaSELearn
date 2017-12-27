package topic1_07;

/*
3.12 Использование исключений в обобщенных функциях*

Создать класс-исключение и класс с обобщенной функцией обмена значений элементов массива.
 Функция должна генерировать исключение, если индексы находятся за пределами массива.
 Протестировать функцию для массивов двух разных типов.
 */

import java.util.Arrays;

public class Task12ExceptionInGenericMethod {
    public static void main(String[] args) {

        Integer[] array = new Integer[2];
        array[0] = 0;
        array[1] = 1;

        try {
            ReplaceGenericMethod.replace(array, 0, -5);
        } catch (ReplaceException e) {
            System.out.println(e.getIndex());
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(array));
    }
}

class ReplaceException extends Exception {
    private final int index;

    public ReplaceException(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

class ReplaceGenericMethod {
    public static <T> void replace(T[] array, int index1, int index2) throws ReplaceException {
        if (index1 < 0 || index1 > array.length - 1) {
            throw new ReplaceException(index1);
        } else if (index2 < 0 || index2 > array.length - 1) {
            throw new ReplaceException(index2);
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index1] = temp;
    }
}

