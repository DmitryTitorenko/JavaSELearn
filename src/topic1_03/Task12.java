package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 03.11.2015.
 *
 * Изменить программу двоичного представления числа так, чтобы не выводились нули вначале.
 * Использовать булеву переменную для индикации того, первый ли это ноль.
 */
public class Task12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte b = s.nextByte();
        byte a;
        boolean c = false;
        for (byte i = 7; i >= 0; i--) {
            a = (byte) (1 & (b >> i));
            if (a == 1) {
                c = true;
            }
            if (c == true) {
                System.out.print(a);
            }
        }
    }
}