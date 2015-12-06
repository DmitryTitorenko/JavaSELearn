package topic1_04;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 25.11.2015.
 * <p>
 * Удаление слов
 * Ввести с клавиатуры строку из нескольких слов, а также некоторую последовательность символов.
 * Удалить из строки слова, содержащие введенную последовательность символов в виде подстроки.
 */
public class Task20RemovingWords {
    public static void main(String[] args) {
        System.out.println(deleteWords());
    }

    private static String deleteWords() {
        Scanner s = new Scanner(System.in);
        String words = s.nextLine();
        String delete = s.next();
        if (words.contains(delete)) {
            words = words.replaceAll(delete, "");
        }
        return words;
    }
}
