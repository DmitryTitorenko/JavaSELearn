package more;

/**
 * Created by Dmitry Titorenko on 25.11.2016.
 */
public class Stack {
    public static void main(String[] args) {
        byte a = 127;
        getBits(a);
        a++;
        getBits(a);
        System.out.println(a);
        a++;
        getBits(a);
        System.out.println(a);
    }

    private static void getBits(byte a) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte i = 7; i >= 0; i--) {
            stringBuilder.append(1 & (a >> i));
        }
        System.out.println(stringBuilder);
    }
}
