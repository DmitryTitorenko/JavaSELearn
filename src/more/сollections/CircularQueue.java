package more.сollections;


import java.util.ArrayDeque;

/**
 * @author Dmitry Titorenko on 24.01.2018
 */
public class CircularQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayQueue = new ArrayDeque<>(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.addLast(5);
        System.out.println(arrayQueue);

        arrayQueue.addLast(6);
        arrayQueue.removeFirst();
        arrayQueue.addFirst(1);
        arrayQueue.addFirst(1);
        arrayQueue.addFirst(1);

        System.out.println(arrayQueue);

    }
}
