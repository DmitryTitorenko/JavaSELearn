package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 02.02.2016.
 * <p>
 * Реализация массива точек через одномерный массив вещественных чисел
 * Реализовать функциональность абстрактного класса AbstractArrayOfPoints, приведенного в примере,
 * через использование одномерного массива вещественных чисел.
 * Каждая пара чисел в массиве должна соответствовать точке.
 * Дополнительно необходимо перекрыть функцию sortByX(), реализовав сортировку выбором.
 */
public class Task9DimensionalArrayOfPoint {
    public static void main(String[] args) {
        new DimensionalArray().test();
    }
}

class DimensionalArray extends AbstractArrayOfPoints {
    private int[] array;

    @Override
    public void deleleteLastPoint() {
        array = Arrays.copyOf(array, array.length - 2);
    }

    @Override
    public void addPoint(int x, int y) {
        if (array == null) {
            array = new int[2];
            array[0] = x;
            array[1] = y;
        } else {
            array = Arrays.copyOf(array, array.length + 2);
            array[array.length - 2] = x;
            array[array.length - 1] = y;
        }
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int getAllCountPoint() {
        return array.length - 1;
    }

    @Override
    public int getY(int i) {
        return array[i + i + 1];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < array.length / 2; i++) {
            s += "i: " + i + " x:" + getX(i) + " y " + getY(i) + "\n";
        }
        return s;
    }

    @Override
    public int getX(int i) {
        return array[i + i];
    }

    @Override
    public void setPoint(int i, int x, int y) {

    }

    @Override
    public void sortY() {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < array.length / 2 + 1; i++) {
                if (array[i + 1] > array[i + 3]) {
                    int x = array[i];
                    int y = array[i + 1];
                    array[i] = array[i + 2];
                    array[i + 1] = array[i + 3];
                    array[i + 2] = x;
                    array[i + 3] = y;
                }
            }
        }
    }

    @Override
    public void sortX() {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < array.length / 2 + 1; i++) {
                if (array[i] > array[i + 2]) {
                    int x = array[i + 2];
                    int y = array[i + 3];
                    array[i + 2] = array[i];
                    array[i + 3] = array[i + 1];
                    array[i] = x;
                    array[i + 1] = y;
                    end = false;
                }
            }
        }
    }
}