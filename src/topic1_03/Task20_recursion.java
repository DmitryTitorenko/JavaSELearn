package topic1_03;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 */
public class Task20_recursion {
    private static int afib = 0;
    private static int b1 = 1;
    private static int b2 = 1;

    public static void main(String[] args) {
        int a = 5;
        fibonachi(a);
    }

    public static void fibonachi(int a) {
        System.out.println(b2);

        b1 = b1 + b2;
        b2 = b1 - b2;
        if (a > afib+1) {
            afib++;
            fibonachi(a);
        }
    }
}
