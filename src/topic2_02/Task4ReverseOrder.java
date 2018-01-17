package topic2_02;

import java.util.*;

/*
3.4 Буквы в обратном порядке

Ввести слово и вывести его буквы в обратном порядке. Использовать стек.
 */
public class Task4ReverseOrder {
    public static void main(String[] args) {
        System.out.println(reverseOrder("Home"));
    }

    public static String reverseOrder(String s) {
        Deque<Character> characters = new ArrayDeque<>();

        for (char a : s.toCharArray()) {
            characters.add(a);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (characters.peekLast() != null) {
            stringBuilder.append(characters.peekLast());
            characters.removeLast();
        }
        return stringBuilder.toString();
    }
}
