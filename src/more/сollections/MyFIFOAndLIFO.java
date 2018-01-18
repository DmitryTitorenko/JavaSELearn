package more.сollections;

import java.util.*;

public class MyFIFOAndLIFO {

    public static void main(String[] args) {

        Queue<Integer> integers = new LinkedList<>();
        for (int i = 5; i > 0; i--) {
            integers.add(i);
        }
        System.out.println("Input: " + integers + "\nLinkedList realise FIFO: ");

        while (!integers.isEmpty()) {
            System.out.println(integers.poll());
        }

        Deque<Integer> integers2 = new LinkedList<>();
        for (int i = 5; i > 0; i--) {
            integers2.add(i);
        }
        System.out.println("Input: " + integers2 + "\nLinkedList realise LIFO: ");

        while (!integers2.isEmpty()) {
            System.out.println(integers2.pollLast());
        }


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 5; i > 0; i--) {
            priorityQueue.add(i);
        }

        System.out.println("Input: 5, 4, 3, 2, 1" + "\n" + "PriorityQueue: ");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
