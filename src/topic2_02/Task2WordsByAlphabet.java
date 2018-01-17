package topic2_02;

/*
3.2 Слова в алфавитном порядке*

Ввести предложение и вывести все различные слова предложения в алфавитном порядке. Использовать множество.
 */

import java.util.*;

public class Task2WordsByAlphabet {
    public static void main(String[] args) {
        String s = "If you know the expected capacity of the StringBuilder beforehand, creating a new one each time should be just as fast as setting a new length";
        System.out.println(test(s));
    }

    public static Set<String> test(String s) {

        Set<String> strings = new TreeSet<>();
        Set<Character> delimiters = new HashSet<>(Arrays.asList(' ', '.', ',', ':', ';', '?', '!', '-', '(', ')', '\"'));
        StringBuilder stringBuilder = new StringBuilder();
        boolean newWord = false;

        for (int i = 0; i < s.length() - 1; i++) {
            if (delimiters.contains(s.charAt(i))) {
                if (newWord) {
                    strings.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    newWord = false;
                }

            } else {
                stringBuilder.append(s.charAt(i));
                newWord = true;
            }
        }
        return strings;
    }
}



