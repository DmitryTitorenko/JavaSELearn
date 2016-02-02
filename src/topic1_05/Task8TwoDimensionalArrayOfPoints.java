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
    int[][] array = new int[1][2];


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
    public void deleleteLastPoint() {
        array = Arrays.copyOf(array, getAllCountPoint() - 1);
    }

    @Override
    public void addPoint(int x, int y) {
        if (array[0][0] == 0 && array[0][1] == 0) {
            array[0][0] = x;
            array[0][1] = y;
        } else {
            int[][] a = new int[array.length + 1][2];
            System.arraycopy(array, 0, a, 0, array.length);
            a[a.length - 1][0] = x;
            a[a.length - 1][1] = y;
            array = a;
        }
        System.out.println(Arrays.deepToString(array));
    }

    @Override
    public int getAllCountPoint() {
        return array.length;
    }

    @Override
    public int getY(int i) {
        return array[i][1];
    }

    public static void testArray() {
        // тест одномерного массива
        int[] a = new int[0];
        System.out.println(Arrays.toString(a));//[]
        a = Arrays.copyOf(a, a.length + 1);//    [0]
        System.out.println(Arrays.toString(a));
        a[a.length - 1] = 1;
        System.out.println(Arrays.toString(a));

        //тест многомерного
        int[][] aa = new int[1][2];
        System.out.println(Arrays.deepToString(aa));//[[0, 0]]
        aa[0][1] = 5;
        System.out.println(Arrays.deepToString(aa));//[[0, 5]]
        //aa=Arrays.copyOf(aa,a.length+1);// not correct: [[0, 0], null]

        int[][] bb = new int[aa.length + 1][2];//correct: [[0, 0], [0, 0]]
        System.arraycopy(aa, 0, bb, 0, aa.length);//теперь можем спокойно копировать
        aa = bb;
        System.out.println(Arrays.deepToString(aa));
        /*
         Можно сделать вывод, что когда мы используем Arrays.copyOf для увеличения одномерного массива на +1,
         то новый элемент массива получает значение 0
         а когда испльзуем Arrays.copyOf для двухмерного массива, то новый элемент массива получет значение null
         поэтому нужно создать новый массив с количеством элементов +1,
         (новые элементы получают значения 0, а не null)
         потом используюя System.arraycopy копируем значения элементов старого массива в новый
         */
    }
}