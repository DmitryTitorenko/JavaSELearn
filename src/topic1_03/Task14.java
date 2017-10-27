package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 * <p>
 * Ввести целое число, разместить его биты в противоположном порядке, вывести в десятичном и в двоичном виде.
 */
public class Task14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte a = s.nextByte();
        initialValue(a);
        invert(a);
    }

    private static void invert(byte a) {
        String result = "";
        for (int i = 0; i <= 7; i++) {
            result += (byte)(1 & (a >> i));
        }
        int  aa=Integer.parseInt(result,2);
        System.out.println("value: " + aa);
        System.out.println("by bits: " + result);
    }

    private static void initialValue(byte a) {
        String result = "";
        for (int i = 7; i >= 0; i--) {
            result += (byte) (1 & (a >> i));
        }
        System.out.println("initial value: " + result);
    }
}