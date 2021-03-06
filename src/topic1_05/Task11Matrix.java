package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 02.02.2016.
 * <p>
 * Матрица
 * Создать класс для представления именованной матрицы со строковым полем - наименованием матрицы и полем,
 * представляющим двумерный массив.
 * Реализовать методы клонирования, проверки эквивалентности и получения строкового представления.
 * Осуществить тестирование.
 */

public class Task11Matrix {
    public static void main(String[] args) throws CloneNotSupportedException {
        Matrix a = new Matrix(10, 10, "go");
        System.out.println(a);
        Matrix b = a.clone();
        a.setArray(2, 2, 9999);
        System.out.println("after change  "+Arrays.deepToString(b.array));
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equals(b));
        Matrix a1 = new Matrix(2, 2, "go");
        Matrix a2 = new Matrix(2, 2, "go");
        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a));
    }
}

class Matrix implements Cloneable {
    private String name;
    public int[][] array;

    Matrix(int a, int b, String name) {
        this.name = name;
        array = new int[a][b];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 1;
            }
        }
    }

    public void setArray(int a, int b, int e) {
        array[a][b] = e;
    }

    @Override
    public String toString() {
        return this.name + Arrays.deepToString(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Matrix))
            return false;
        Matrix a = (Matrix) obj;
        if (!(Arrays.deepEquals(array, a.array)))
            return false;
        return this.name.equals(a.name);
    }

    @Override
    protected Matrix clone() throws CloneNotSupportedException {
        Matrix m = (Matrix) super.clone();
        int a[][]=this.array.clone();
        for (int i = 0; i <this.array.length; i++) {
            a[i]=this.array[i].clone();
        }
        m.array=a;
        return m;
    }
}
