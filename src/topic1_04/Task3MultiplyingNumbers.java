package topic1_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 06.11.2015.
 *
 * Проинициализировать двумерный массив целых чисел списком начальных значений,
 * найти произведение ненулевых (неравных нулю) элементов и вывести на экран.
 * Для пропуска нулевых элементов использовать оператор continue.
 */
public class Task3MultiplyingNumbers {
    public static void main(String[] args) {
        System.out.println("Введите размерность двухмерного массива");
        Scanner s = new Scanner(System.in);

        int[][] a = new int[s.nextInt()][s.nextInt()];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = s.nextInt();
            }
        }
        int sum = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0) {
                    sum *= a[i][j];
                } else {
                    continue;
                }
            }
        }
        System.out.printf(Arrays.deepToString(a) + "%nsum: " + sum);
    }
}