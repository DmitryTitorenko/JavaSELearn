package topic2_04;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Dmitry Titorenko on 25.01.2018
 * <p>
 * 3.1 Вывод значения с учетом всех возможных локализаций
 * <p>
 * Ввести с клавиатуры действительное значение, вывести его в консольное окно с учетом всех доступных локализаций.
 */
public class Task1 {

    public static void main(String[] args) {

        Locale list[] = NumberFormat.getAvailableLocales();

        for (Locale locale : list) {
            NumberFormat qq = NumberFormat.getInstance(locale);
            try {
                System.out.println(qq.parse("10").doubleValue());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(locale.getDisplayName());
        }
    }
}
