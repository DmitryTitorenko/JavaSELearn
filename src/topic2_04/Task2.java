package topic2_04;

import java.util.*;

/**
 * @author Dmitry Titorenko on 25.01.2018
 * <p>
 * 3.2 Вывод слов предложения в обратном порядке
 * <p>
 * Ввести с клавиатуры предложение с помощью функции nextLine() объекта типа Scanner.
 * Вывести в консольное окно слова предложения в обратном порядке. Использовать функцию split().
 */
public class Task2 {
    public static void main(String[] args) {
        String s = "1 2 3 4 5";
        String[] a = s.split(" ");
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
            System.out.println();
        }

        System.out.println("\nUse Deque:");
        Deque list = new LinkedList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        while (list.isEmpty() != true) {
            System.out.println(list.removeLast());
        }


        System.out.println("\nUse NavigableSet:");
        NavigableSet sortedSet = new TreeSet();
        for (int i = 0; i < a.length; i++) {
            sortedSet.add(a[i]);
        }
        while (sortedSet.size() != 0) {
            System.out.println(sortedSet.pollLast());
        }
    }
}
