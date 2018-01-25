package topic2_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dmitry Titorenko on 25.01.2018
 * <p>
 * 3.5 Нахождение всех подстрок, удовлетворяющих определенным требованиям*
 * <p>
 * Ввести строку, найти и вывести на экран, вывести все подстроки, которые соответствуют шаблону.
 */
public class Task5 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("text");
        Matcher matcher = pattern.matcher("textual 4yttextual textualedf");
        while (matcher.find()) {
            System.out.printf("Найден текст" + " \"%s\", начиная с позиции"
                            + "%d и заканчивая позицией %d.%n", matcher.group(),
                    matcher.start(), matcher.end());
        }
    }
}
