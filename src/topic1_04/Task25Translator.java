package topic1_04;

import java.util.Scanner;

/**
 * <p>
 * Транслятор
 * <p>
 * Ввести с клавиатуры строку программного кода.
 * Проверить соответствие фигурных скобок Заменить открывающиеся фигурные скобки словом begin,
 * а закрывающиеся – словом end. Использовать класс StringBuilder.
 */
public class Task25Translator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();     //  }234}234} {234{2{{
        System.out.println(translator(st));
    }

    private static StringBuilder translator(String st) {
        StringBuilder sb = new StringBuilder(st);
        int openBrace = 0;
        int closeBrace = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '}')
                closeBrace++;
        }
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '{')
                openBrace++;
        }
        if (closeBrace < openBrace) {
            for (int i = closeBrace; i < openBrace; i++) {
                sb.append("}");
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '{') {
                sb.replace(i, i + 1, "begin");
            } else if (sb.charAt(i) == '}') {
                sb.replace(i, i + 1, "end");
            }
        }
        return sb;
    }
}
