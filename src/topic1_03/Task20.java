package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 * <p>
 * Реализовать программу поиска чисел Фибоначчи:
 * F(1) = F(2) = 1; F(n) = F(n - 2) + F(n - 1)
 * Поиск n-го числа Фибоначчи осуществлять в отдельной функции.
 * В функции main() осуществить ввод номера числа и вывод всех чисел Фибоначчи до введенного номера включительно.
 * Реализовать два варианта - с использованием цикла и с использованием рекурсии.
 */
public class Task20 {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        int b1 = 1;//n-1
        int b2 = 1;//n-2
        while (a > b2) {
            System.out.println("" + b2);
            b1 = b1 + b2;
            b2 = b1 - b2;
        }
    }
}
