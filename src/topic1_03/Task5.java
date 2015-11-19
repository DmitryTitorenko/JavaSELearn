package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 01.11.2015.
 *
 * Разработайте программу, которая реализует алгоритм решения квадратного уравнения.
 * Алгоритм должен учитывать все возможные данные.
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("inser a");
        double a = s.nextDouble();
        System.out.println("insert b");
        double b = s.nextDouble();
        System.out.println("insert c");
        double c = s.nextDouble();
        double D;
        double x1;
        double x2;
        D = Math.pow(b, 2) - 4 * a * c;
        if (D > 0) {
            x1 = ((-b + Math.sqrt(D)) / (2 * a));
            x2 = ((-b - Math.sqrt(D)) / (2 * a));// не верно без ()//2*а
            System.out.printf("x1=" + x1 + " x2=" + x2);
        } else if (D == 0) {
            x1 = b / 2 * a;
            System.out.printf("x1=x2=" + x1);
        } else if (D < 0) {
            System.out.println("NULL");
        }
    }
}