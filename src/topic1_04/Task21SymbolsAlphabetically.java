package topic1_04;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 25.11.2015.
 * <p>
 * Символы по алфавиту
 * Ввести с клавиатуры строку. Удалить из строки все цифры. Рассортировать все ее символы по алфавиту.
 * Вывести полученные символы в виде новой строки.
 */

public class Task21SymbolsAlphabetically {
    public static void main(String[] args) {
        String deleteN = deleteNumbers();
        System.out.println(deleteN);

        String arraysting = sortString(deleteN);
        System.out.println(arraysting);
    }

    private static String deleteNumbers() {
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        for (int i = 0; i < 10; i++) {
            String delete = String.valueOf(i);
            if (word.contains(delete)) {
                word = word.replaceAll(delete, "");
            }
        }
        return word;
    }

    private static String sortString(String words) {
        String[] arraysting = new String[words.length()];
        for (int i = 0; i < words.length(); i++) {
            arraysting[i] = String.valueOf(words.charAt(i));
        }
        Arrays.sort(arraysting);
        String s = "";
        for (String a : arraysting) {
            s += a;
        }
        return s;
    }
}
