package topic2_03;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Dmitry Titorenko on 22.01.2018
 * <p>
 * 3.4 Создание собственного контейнера на базе массива*
 * Создать обобщенный класс для представления одномерного массива, индекс элементов которого меняется от определенного значения From до значения To включительно.
 * Эти значения могут быть как положительными, так и отрицательными.
 * Класс должен реализовывать интерфейс Collection.
 * Рекомендуется использовать класс AbstractList в качестве базового.
 */
public class Task4ListWithSetIndex {
    public static void main(String[] args) {
        ListWithSetIndex<Integer> integers = new ListWithSetIndex<>();
        integers.setIndex(5, 8);
        integers.add(1);
        integers.add(6, 2);
        System.out.println(integers.get(5));
        System.out.println(integers.get(6));

        integers.set(5, 0);
        System.out.println(integers.get(5));

        integers.remove(5);
        System.out.println("get(5)\n" + integers.get(5));
        System.out.println("size:\n" + integers.size());
        System.out.println("indexOf\n" + integers.indexOf(2));

        integers.add(2);
        System.out.println("lastIndexOf\n" + integers.lastIndexOf(2));

        System.out.println("foreach");

        for (int e : integers) {
            System.out.println(e);
        }
    }
}

class ListWithSetIndex<E> extends AbstractList<E> {

    ArrayList<E> arr;
    private int from;
    private int to;

    public void setIndex(int from, int to) {
        this.from = from;
        this.to = to;
        int capacity = getCapacity();
        arr = new ArrayList<>(capacity);
    }

    private int getCapacity() {
        int capacity;
        if (from > 0 & to > 0) {
            capacity = to - from;
        } else if (from < 0 & to > 0) {
            capacity = to + Math.abs(from);
        } else {
            capacity = Math.abs(from) - Math.abs(to);
        }
        return capacity;
    }

    private int getCorrectIndex(int index) {
        return from > 0 ? index - from : index + Math.abs(from);
    }

    @Override
    public E get(int index) {
        return arr.get(getCorrectIndex(index));
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public void add(int index, E element) {
        arr.add(getCorrectIndex(index), element);
    }

    @Override
    public boolean add(E e) {
        return arr.add(e);
    }

    @Override
    public E set(int index, E element) {
        return arr.set(getCorrectIndex(index), element);
    }

    @Override
    public E remove(int index) {
        return arr.remove(getCorrectIndex(index));
    }

    @Override
    public int indexOf(Object o) {
        return arr.indexOf(o) + from;
    }

    @Override
    public int lastIndexOf(Object o) {
        return arr.lastIndexOf(o) + from;
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
