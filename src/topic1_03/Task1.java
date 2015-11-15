package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 01.11.2015.
 *
 * Реализовать алгоритм и программу, в которой вводится два числа и определяется их
 * среднее геометрическое – квадратный корень из их произведения. Для обозначения
 * умножения в Java, как и в других языках программирования, используется знак *.
 * Использовать форматированный вывод.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a = s.nextDouble();
        double b = s.nextDouble();
        System.out.println("Среднее геометрическое чисел: " + Math.sqrt(a * b));
    }
}