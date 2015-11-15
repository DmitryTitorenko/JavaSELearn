package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 02.11.2015.
 *
 * Ввести значение n (от 0 до 10) и вывести значения степеней числа 8 до n включительно.
 * Реализовать два подхода – с использованием арифметических и побитовых операций.
 */
public class Task11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a = 8;
        int pow = 1;
        if (n < 0 || n > 10) {
            System.out.println("0<n<10");
        } else {
            for (int i = 1; i <= n; i++) {
                pow *= a;
                System.out.println(pow);
            }
        }
    }
}