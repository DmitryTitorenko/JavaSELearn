package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 01.11.2015.
 *
 * Напишите программу, которая выполняет предыдущее задание с использованием условных операций.
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        int y = (x == 0 ? 0 : (x < 0 ? -1 : 1));
        System.out.println(y);
    }
}