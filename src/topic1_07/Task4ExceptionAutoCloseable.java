package topic1_07;

/*
3.5 Реализация интерфейса AutoCloseable*

Реализовать программу, в которой вводятся элементы массива заданной длины и по окончании выводятся введенные элементы,
даже если при вводе возникли исключения (ошибка преобразования строки в число, выход за границы массива).
Использовать объект класса, реализующего интерфейс AutoCloseable.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task4ExceptionAutoCloseable {
    public static void main(String[] args) {
        test(3);

    }

    public static void test(int length) {
        Scanner scanner = new Scanner(System.in);
        int input;

        try (ElementsArray elementsArray = new ElementsArray()) {// try-with-resources
            elementsArray.setArray(length);

            for (int i = 0; i < 4; i++) {// set 4 - we can get out array bounds
                input = scanner.nextInt();
                elementsArray.addElement(input);
            }
        } catch (Exception e) {// before we catch exception method elementsArray.close() will be invoke;.
            e.printStackTrace();
        }
    }
}

class ElementsArray implements AutoCloseable {// implement AutoCloseable to override close() method
    private int[] array;
    private int index;

    @Override
    public void close() throws Exception {
        System.out.println(Arrays.toString(array));

    }

    public void setArray(int length) {
        this.array = new int[length];
    }

    public void addElement(int element) {
        array[index] = element;
        index++;
    }
}
