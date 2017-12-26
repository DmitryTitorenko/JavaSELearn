package topic1_07;

import java.util.ArrayList;
import java.util.Arrays;

/*
3.9 Использование ограниченных подстановочных типов

Создать класс, содержащий статическую функцию добавления в конец некоторых списков
 (первый параметр) чисел из массива целых (второй параметр).
 Реализовать отдельную функцию и осуществить ее тестирование для двух массивов различных типов.
 */

public class Task9WildCard {
    public static void main(String[] args) {
        ArrayList<Number> doubles = new ArrayList<>();
        doubles.add(1);
        Integer[] integer = new Integer[2];
        integer[0] = 2;
        integer[1] = 3;

        System.out.println(MyWildcard1.addSome(doubles, integer));
    }
}

class MyWildcard1 {
    public static ArrayList<? super Integer> addSome(ArrayList<? super Integer> arrayList, Integer[] t) {
        arrayList.addAll(Arrays.asList(t));
        return arrayList;
    }
}
