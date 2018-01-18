package more.сollections;

import java.util.NavigableSet;
import java.util.TreeSet;

public class MyTreeSet {
    private static NavigableSet<Integer> integers = new TreeSet<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        System.out.println(integers + "\n" + integers.higher(2) + " higher(2)\n" +
                integers.lower(2) + " lower(2) \n" +
                integers.headSet(2) + " headSet(2) \n" +
                integers.tailSet(2) + " tailSet(2)\n" +
                integers.descendingSet() + " descendingSet()" + "\n" +
                integers.pollFirst() + " pollFirst()\n" +
                integers + "\n" +
                integers.pollLast() + " pollLast()\n" +
                integers);
    }
}
