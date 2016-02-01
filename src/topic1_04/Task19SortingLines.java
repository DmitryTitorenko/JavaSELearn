package topic1_04;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 25.11.2015.
 * <p>
 * Сортировка строк
 * Проинициализировать одномерный массив строк.
 * Отсортировать массив по алфавиту. Сшить все слова в новую строку.
 */
public class Task19SortingLines {
    public static void main(String[] args) {
        System.out.println(sortingLines());
    }

    private static String sortingLines() {
        String[] s = {"f", "g", "w", "a"};
        Arrays.sort(s);
        String result = "";
        for (String e : s) {
            result += e;
        }
        return result;
    }
}
