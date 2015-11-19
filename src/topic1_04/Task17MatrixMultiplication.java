package topic1_04;


import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 18.11.2015.
 * <p>
 * Перемножение матриц
 * Разработать функцию для перемножения двух матриц с проверкой размерностей
 * и осуществить тестирование этой функции с проверкой возможных ошибок.
 * + реализовано суммирование
 */
public class Task17MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2},
                {3, 4}
        };
        int[][] b = {
                {5, 6},
                {7, 8}
        };
        int[][] composition = composition(a, b);
        out(composition);
        System.out.println(composition[1][0]);

        int[][] sum = sum(a, b);
        out(sum);

    }

    private static int[][] sum(int[][] a, int[][] b) {
        if (a == null || b == null || a.length != b.length) {
            return null;
        }
        int[][] sum = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) {
                return null;
            }
            for (int j = 0; j < a[i].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    private static int[][] composition(int[][] a, int[][] b) {
        if (a == null || b == null || a.length != b.length) {
            return null;
        }
        int[][] composition = new int[a.length][a[0].length];
        for (int i = 0; i < composition.length; i++) {
            for (int j = 0; j < composition[i].length; j++) {
                composition[i][j] = 0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) {
                return null;
            }
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a.length; k++) {
                    composition[i][j] += a[i][k] * b[k][j]; //a[i1][j+1] * b[i + 1][j];
                    // столбцы массива-j, а строки-i
                }
            }
        }
        return composition;
    }

    private static void out(int[][] sum) {
        if (sum != null) {
            System.out.println(Arrays.deepToString(sum));
        } else {
            System.out.println("Insert correct value");
        }
    }
}
