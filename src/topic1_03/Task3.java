package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 01.11.2015.
 *
 * Напишите программу, которая считывает x и вычисляет y, используя инструкцию if
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        int y;
        if (x < 0) {
            y = -1;
            System.out.print("y: " + y);
        } else if (x > 0) {
            y = 1;
            System.out.println("y: " + y);
        } else if (x == 0) {
            y = 0;
            System.out.println("y: " + y);
        }
    }
}

