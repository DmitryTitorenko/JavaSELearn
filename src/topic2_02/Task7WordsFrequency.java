package topic2_02;

/*
3.7 Определение частоты вхождения букв*

Ввести предложение и вывести все различные буквы, входящие в предложение и количество их вхождения.
 Использовать ассоциативный массив.
 */

import java.util.*;

public class Task7WordsFrequency {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("b");
        System.out.println(strings);

        Map<String, Integer> letters = new HashMap<>();
        for (String i : strings) {
            letters.putIfAbsent(i, 0);
            letters.put(i, letters.get(i) + 1);

            //letters.merge(i,1,Integer::sum);
        }
        System.out.println(letters);
    }
}
