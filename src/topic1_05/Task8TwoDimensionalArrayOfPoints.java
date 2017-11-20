package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 01.02.2016.
 * <p>
 * Реализация массива точек через двумерный массив
 * Реализовать функциональность абстрактного класса AbstractArrayOfPoints, приведенного в примере,
 * через использование двумерного массива вещественных чисел. Каждая строчка массива должна соответствовать точке.
 * Осуществить тестирование класса.
 */
public class Task8TwoDimensionalArrayOfPoints {

    public static void main(String[] args) {
        new TwoDimensionalArray().test();
    }
}

class TwoDimensionalArray extends AbstractArrayOfPoints {
    private int array[][] = new int[1][2];

    @Override
    public void setPoint(int i, int x, int y) {
        array[i][0] = x;
        array[i][1] = y;
    }

    @Override
    public int getX(int i) {
        return array[i][0];
    }

    @Override
    public int getY(int i) {
        return array[i][1];
    }

    @Override
    public int getAllCountPoint() {
        return array.length;
    }

    @Override
    public void addPoint(int x, int y) {
        if (array[0][0] == 0 && array[0][1] == 0) {
            array[0][0] = x;
            array[0][1] = y;
        } else {
            int a[][] = new int[array.length + 1][2];
            System.arraycopy(array, 0, a, 0, array.length);
            a[a.length - 1][0] = x;
            a[a.length - 1][1] = y;
            array = a;
        }
    }

    @Override
    public void deleleteLastPoint() {
        array = Arrays.copyOf(array, array.length - 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

