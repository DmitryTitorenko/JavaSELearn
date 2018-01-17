package topic2_02;

import java.util.ArrayDeque;
import java.util.Deque;

/*
3.5 Проверка корректности скобок с учетом кавычек*

Дополнить пример 6.6 проверкой, не находятся ли скобки в кавычках. В этом случае они должны игнорироваться.
 */

public class Task5Deque {
    public static void main(String[] args) {
        Deque<Character> brackets = new ArrayDeque<>();
        char e = '"';
        String s = "( ( ) " + e + ") ";
        boolean withoutBraces = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '"') {
                withoutBraces = !withoutBraces;
            }
            if (s.charAt(i) == '(' & withoutBraces) {
                brackets.push('(');
            }
            if (s.charAt(i) == ')' & withoutBraces)
                brackets.pop();
        }
        if (brackets.isEmpty()) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect  ");
        }
    }
}
