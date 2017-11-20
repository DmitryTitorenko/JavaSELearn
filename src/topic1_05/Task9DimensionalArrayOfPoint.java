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
        int currentIndexMin;
        int tempX;
        int tempY;
        for (int i = 1; i < array.length; i += 2) {
            boolean changeMin = false;

            currentIndexMin = i;

            for (int j = i; j < array.length; j += 2) {
                changeMin = false;

                if (array[j] < array[currentIndexMin]) {
                    currentIndexMin = j;
                    changeMin = true;
                }
            }
            if (changeMin) {
                tempX = array[i - 1];
                tempY = array[i];
                array[i - 1] = array[currentIndexMin - 1];
                array[i] = array[currentIndexMin];
                array[currentIndexMin - 1] = tempX;
                array[currentIndexMin] = tempY;
            }
        }
    }


    @Override
    public void sortX() {
        int currentIndexMin;
        int tempX;
        int tempY;
        for (int i = 0; i < array.length; i += 2) {
            boolean changeMin = false;

            currentIndexMin = i;

            for (int j = i; j < array.length; j += 2) {
                changeMin = false;

                if (array[j] < array[currentIndexMin]) {
                    currentIndexMin = j;
                    changeMin = true;
                }
            }
            if (changeMin) {
                tempX = array[i];
                tempY = array[i + 1];
                array[i] = array[currentIndexMin];
                array[i + 1] = array[currentIndexMin + 1];
                array[currentIndexMin] = tempX;
                array[currentIndexMin + 1] = tempY;
            }
        }
    }
}

