package topic1_04;

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
        System.out.println(makePoint);
        String selectLetter = selectLetter(makePoint);
        System.out.println(selectLetter);
    }

    private static String deleteSpace() {
        Scanner s = new Scanner(System.in);
        String words = s.nextLine();
        if (words.indexOf(" ") == 0) {
            words = words.substring(1, words.length());
        }
        if (words.lastIndexOf(" ") == words.length() - 1) {
            words = words.substring(0, words.length() - 1);
        }
        if (words.contains("  ")) {
            words = words.replaceAll("  ", " ");
        }
        return words;
    }

    private static String makeLittleWords(String a) {
        String[] ee = a.split(" ");
        String result = "";
        for (int iii = 0; iii < ee.length; iii++) {
            String as = ee[iii];
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
            if (iii != ee.length - 1) {
                result += " ";
            }
        }
        return result;
    }

    //GRGRGgf. RGRG GHrgrh ьывашуЩВАО ЬщывашсДШВА
    private static String makePoint(String a) {
        String result = "";
        String[] ee = a.split(" ");
        for (int i = 0; i < ee.length; i++) {
            char[] ou = ee[i].toCharArray();
            if (Character.isUpperCase(ou[0]) && i != 0) {//did't add "." to first word
                if (!ee[i - 1].contains(".")) {// check for contain "." in previous word
                    ee[i - 1] += ".";
                }
            }
        }
        for (int i = 0; i < ee.length; i++) {
            result += ee[i];
            if (i != ee.length - 1) {
                result += " ";
            }
        }
        return result;
    }

    private static String selectLetter(String a) {
        String[] ee = a.split(" ");
        String result = "";
        for (String s : ee) {
            if (s.indexOf("ь") == 0 || s.indexOf("Ь") == 0) {
                result += s + " ";
            }
        }
        return result;
    }
}
