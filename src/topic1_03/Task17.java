package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 *
 * Реализовать программу, в которой вычисление факториала осуществляется отдельной функцией.
 * Факториал должен вычисляться с помощью цикла. Осуществить тестирование функции.
 * Предусмотреть отдельные функции для ввода значения n, вычисления факториала и вывода результата.
 */
public class Task17 {
    public static void main(String[] args) {
        int a = insert();
        int b = calculation(a);
        out(b);
    }

    public static int insert() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        return a;
    }

    public static int calculation(int a) {
        int b = 1;
        for (int i = 1; i <= a; i++) {
            b *= i;
        }
        return b;
    }

    public static void out(int a) {
        System.out.println(a);
    }
}
