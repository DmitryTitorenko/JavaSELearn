package more.сollections;


import java.util.*;

public class TestOne {

    public static void main(String[] args) {

        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(2, "2 value");
        integerStringMap.put(3, "3 value");
        for (Map.Entry<Integer, String> integerStringEntry : integerStringMap.entrySet()) {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
            integerStringEntry.setValue("555");

        }
        System.out.println(integerStringMap.toString());


        int a[] = {5, 8, 1};
        math(a);
    }

    public static void math(int[] array) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare((Integer) o1, (Integer) o2);
            }
        });


        for (int i = 0; i < array.length; i++) {
            priorityQueue.add(array[i]);
        }

        System.out.println(priorityQueue);

    }


}



