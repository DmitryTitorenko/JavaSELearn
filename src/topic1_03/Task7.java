package topic1_03;

/**
 * Created by Dmitry Titorenko on 02.11.2015.
 *
 * Выведите на экран символы, коды которых находятся в диапазоне от 1072 до 1120
 */
public class Task7 {
    public static void main(String[] args) {
        for (int i = 1072; i < 1120; i++) {
            char a = (char) i;
            System.out.println(a);
        }
    }
}