package topic1_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 25.11.2015.
 * <p>
 * Корректор
 * Ввести с клавиатуры строку. Удалить лишние пробелы, в том числе начальные и конечные.
 * Внутри слов большие буквы заменить маленькими.
 * Если перед словами, начинающимися с большой буквы, нет точки, добавить точку в конце предшествующих слов.
 * Сформировать и вывести на экран слова, начинающиеся на мягкий знак.
 */
public class Task23Corrector {
    public static void main(String[] args) {
        String words = deleteSpace();
        System.out.println(words);
        String makeLittleWords = makeLittleWords(words);
        System.out.println(makeLittleWords);
        String makePoint = makePoint(makeLittleWords);
        // System.out.println(makePoint);
    }

    private static String deleteSpace() {
        Scanner s = new Scanner(System.in);
        String words = s.nextLine();
        if (words.contains("  ")) {
            words = words.replaceAll("  ", " ");
        }
        if (words.indexOf(" ") == 0) {
            words = words.substring(1, words.length());
        }
        if (words.lastIndexOf(" ") != -1) {//ошибка
            words = words.substring(0, words.length() - 1);
        }
        return words;
    }

    private static String makeLittleWords(String a) {
        String[] ee = a.split(" ");
        String result = "";
        for (String as : ee) {
            char[] linechar = as.toCharArray();
            for (int i = 0; i < linechar.length; i++) {
                if (i == 0) {
                    result += linechar[i];
                } else {
                    if (Character.isUpperCase(linechar[i])) {
                        result += Character.toLowerCase(linechar[i]);
                    } else {
                        result += linechar[i];

                    }
                }
            }
            result += " ";
        }

        return result;
    }

    private static String makePoint(String a) {
        String[] ee = a.split(" ");
        int i = 1;
        for (String qa : ee) {
            char[] asd = qa.toCharArray();
            if (Character.isUpperCase(asd[0])) {
                ee[i - 1] = ee[i - 1] + ".";

            }

        }
        return Arrays.toString(ee);

    }
}
