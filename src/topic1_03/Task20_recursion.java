package topic1_03;

/**
 * Created by Dmitry Titorenko on 04.11.2015.
 */
public class Task20_recursion {
    private static int b1 = 1;
    private static int b2 = 1;

    public static void main(String[] args) {
        int a = 50;
        fibonachi(a);
    }

    private static void fibonachi(int a) {
        System.out.println(b2);
        b1 = b1 + b2;
        b2 = b1 - b2;
        if (a > b2) {
            fibonachi(a);
        }
    }
}
