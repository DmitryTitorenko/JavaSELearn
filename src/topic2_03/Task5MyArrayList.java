package topic2_03;

import java.util.*;

/**
 * @author Dmitry Titorenko on 23.01.2018
 * <p>
 * 3.5 "Гибкий" массив*
 * Создать обобщенный класс для представления одномерного массива, который автоматически расширяется, когда пользователь обращается к несуществующему элементу.
 * Например, если создан пустой массив a, первое обращение (для чтения или записи) к элементу по индексу обеспечит расширение массива так,
 * чтобы он содержал n + 1 элемент с индексами от 0 до n-го включительно.
 * Если определенные элементы уже существовали, они сохраняются и массив дополняется новыми элементами.
 * Если элемент с индексом уже существует, осуществляется обычное обращение.
 * Создать метод получения количества элементов, методы доступа по индексу, метод предоставления итератора, а также перекрыть функцию ToString().
 * Осуществить тестирование всех возможностей класса.
 */
public class Task5MyArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.toString();
        integers.remove(0);
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(0, 2);
        myArrayList.remove(1);
        System.out.println(myArrayList);
    }
}

class MyArrayList<T> extends AbstractList<T> {
    private T[] elementData;
    private int size;


    protected MyArrayList() {
        elementData = (T[]) new Object[1];
    }

    @Override
    public boolean add(T t) {
        add(t, elementData, size);
        return true;

    }

    private void add(T t, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow(size + 1);
        elementData[s] = t;
        size = s + 1;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                minCapacity);
    }

    public T remove(int index) {

        T oldValue = elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        /*
        example how to delete use arraycopy
        we have array 11233
        want to delete 2
        copy 33 with replace 2

          33 =>
        112  =>
        1133
         */

        return oldValue;
    }


    @Override
    public T get(int index) {
        return elementData[index];
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            T t = it.next();
            sb.append(t == this ? "(this Collection)" : t);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
}
