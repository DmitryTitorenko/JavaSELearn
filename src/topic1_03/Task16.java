package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 03.11.2015.
 * <p>
 * Реализовать и протестировать функцию, которая вычисляет наименьшее
 * общее кратное двух чисел путем деления произведения чисел на наибольший общий делитель.
 */
public class Task16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = a * b / (greatestCommonDivisor(a, b));//Наименьшее общее кратное
        System.out.println(c);
    }

    private static int greatestCommonDivisor(int a, int b) {//Наибольший общий делитель
        while (a != b) {
            if (a < b) {
                b -= a;
            }
            if (a > b) {
                a -= b;
            }
        }
        return a;
    }
}
