package topic2_04;

import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Pattern;

/**
 * @author Dmitry Titorenko on 25.01.2018
 *
 * 3.6 Маска файла*
 *
 * Вывести имена файлов, удовлетворяющих маске файла. Файл должен начинаться на определенное сочетание букв,
 * первая буква должна быть задана как вариант из двух букв, длина имени не определена,
 * расширение файла задать как одно из трех возможных вариантов. Имя папки файла задать точно.
 */
public class Task6 {

    public static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";

    public static void main(String[] args) {
        System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд", "Украина"));

        Pattern p = Pattern.compile("\\+?(380-)?((57-)?\\d{3}|(572-)?\\d{2})-\\d{2}-\\d{2}$");

    }
}
