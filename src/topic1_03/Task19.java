package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 *
 * Реализовать программу поиска простых чисел. Проверку, является ли число простым,
 * осуществлять в отдельной функции, которая принимает целое число и возвращает результат типа boolean.
 * В функции main() осуществить ввод необходимого диапазона и вывод всех простых чисел в этом диапазоне.
 */
public class Task19 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите начальный диапазон");
        int a = s.nextInt();
        System.out.println("Введите конечный диапазон");
        int b = s.nextInt();
        for (int i = a; i < b; i++) {
            isPrime(i);
            if (isPrime(i) == true) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }
}
