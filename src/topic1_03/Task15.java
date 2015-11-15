package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 03.11.2015.
 *
 * Реализовать функцию, которая вычисляет y (функция signum):
 */
public class Task15 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        System.out.println(signum(c));
    }

    public static int signum(int a) {
        if (a < 0) {
            return -1;
        } else if (a > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
