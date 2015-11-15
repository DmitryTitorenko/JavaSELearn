package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 02.11.2015.
 *
 * Напишите программу, в которой вводится n и вычисляется следующая сумма:
 * y = 1 + 1/2 + 1/3 + 1/4 + 1/5 + ... + 1/n
 * Необходимо реализовать три варианта программы с тремя вариантами инструкций цикла.
 */
public class Task8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        double b = 0;
        for (double i = 1; i <= a; i++) {
            b += 1 / i;
        }
        System.out.println("for: " + b);
        double i1 = 1;
        double b1 = 0;
        while (i1 <= a) {
            b1 += 1 / i1;
            i1++;
        }
        System.out.println("while: " + b1);
        double i2 = 1;
        double b2 = 0;
        do {
            b2 += 1 / i2;
            i2++;
        }
        while (i2 <= a);
        System.out.println("do while: " + b2);
    }


}