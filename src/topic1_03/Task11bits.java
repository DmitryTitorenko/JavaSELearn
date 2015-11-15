package topic1_03;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 03.11.2015.
 */
public class Task11bits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int pow;
        if (n < 0 || n > 10) {
            System.out.println("0<n<10");
        } else {
            for (int i = 1; i <= n; i++) {
                pow = 8 << 3 * i;
                System.out.println(pow);
            }
        }
    }
}