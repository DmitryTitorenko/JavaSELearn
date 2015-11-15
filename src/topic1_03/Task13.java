package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 03.11.2015.
 *
 * Написать программу инвертированного двоичного представления числа так
 * (в обратном порядке, слева – младшие биты, а справа – старшие).
 */
public class Task13 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte b = s.nextByte();
        byte a;
        for (byte i = 0; i <= 7; i++) {
            a = (byte) (1 & (b >> i));
            System.out.print(a);
        }
    }
}
