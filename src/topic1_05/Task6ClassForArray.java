package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 31.01.2016.
 * <p>
 * Класс для представления массива
 * Добавить к классу, представляющему массив, функцию удаления последнего элемента.
 * Добавить в функции main() ввод данных с клавиатуры.
 */
public class Task6ClassForArray {
    public static void main(String[] args) {
        ArrayForDouble a = new ArrayForDouble(10);
        a.add(15);
        System.out.println(a);
        a.delete();
        System.out.println(a);
    }
}

class ArrayForDouble {
    private double[] array;

    public ArrayForDouble(double a) {

        array = new double[]{a};
    }

    public void add(double a) {
        double[] newarray = Arrays.copyOf(array, array.length + 1);
        newarray[newarray.length - 1] = a;
        array = newarray;
    }

    public void delete() {
        array = Arrays.copyOf(array, array.length - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
