package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 02.11.2015.
 *
 * Напишите программу, которая считывает целое n и вычисляет y с помощью инструкции switch:
 */
public class Task6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int y;
        switch (n) {
            case 0:
                y = 2;
                break;
            case 1:
                y = 4;
                break;
            case 2:
                y = 5;
                break;
            case 3:
                y = 3;
                break;
            case 4:
                y = 1;
                break;
            default:
                y = 0;
                break;
        }
        System.out.println(y);
    }
}