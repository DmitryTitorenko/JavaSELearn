package topic1_04;

import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 25.11.2015.
 * <p>
 * Аббревиатура
 * Ввести с клавиатуры строку из нескольких слов.
 * Составить строку из первых букв слов с переводом этих букв в верхний регистр.
 */
public class Task22Abbreviation {
    public static void main(String[] args) {
        String[] splitString = splitString();
        String firstwords = firstWords(splitString);
        String touppercase = mytoUpperCase(firstwords);
        System.out.println(touppercase);
    }

    private static String[] splitString() {
        Scanner s = new Scanner(System.in);
        String words = s.nextLine();
        return words.split(" ");
    }

    private static String firstWords(String[] splitString) {
        String firstwords = "";
        for (String s : splitString) {
            firstwords += String.valueOf(s.charAt(0));
        }
        return firstwords;
    }

    private static String mytoUpperCase(String a) {
        return a.toUpperCase();
    }
}
