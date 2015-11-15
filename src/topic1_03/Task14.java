package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 *
 * Ввести целое число, разместить его биты в противоположном порядке, вывести в десятичном и в двоичном виде.
 */
public class Task14 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        byte a=s.nextByte();
        byte b = (byte) ~a;
        byte b1;
        System.out.println(b);
        for (int i = 7; i >= 0; i--) {
            b1 = (byte) (1 & (b >> i));
            System.out.print(b1);
        }
    }
}