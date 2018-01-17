package topic2_02;

import java.util.*;

/*

3.3 Среднее арифметическое*

Реализовать программу, в которой вводятся вещественные числа, выводятся в порядке возрастания модулей,
 а также вычисляется их среднее арифметическое. Использовать PriorityQueue.
 */
public class Task3ArithmeticMiddling {
    public static void main(String[] args) {
        Collection<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 8, -4, 8, -2, 4, -7, 3));

        Collection<Integer> integers = toPriorityQueue(arrayList);

        System.out.println(integers);
        System.out.println(arithmeticMiddling(integers));

    }

    public static Collection<Integer> toPriorityQueue(Collection<Integer> integers) {
        Collection<Integer> integers1 = new PriorityQueue<>();
        for (Integer integer : integers) {
            integers1.add(Math.abs(integer));
        }
        return integers1;
    }

    public static double arithmeticMiddling(Collection<Integer> integers) {
        Iterator<Integer> integerIterator = integers.iterator();
        double a = 0;
        while (integerIterator.hasNext()) {
            a += integerIterator.next();
        }
        return a / integers.size();
    }
}
