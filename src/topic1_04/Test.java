package topic1_04;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by GrinWey on 11/21/2015.
 */
public class Test<T> extends AbstractQueue<T> {

    private Object[] array;
    int indexfirst;
    int indexend;

    public Test(int size, int indexfirst, int indexend) {
        array = new Object[size];
        this.indexfirst = indexfirst;
        this.indexend = indexend;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                boolean end;
                if (indexfirst < array.length) {
                    end = array[indexfirst] == null;
                } else {
                    remove();

                    indexfirst = 0;
                    end = array[indexfirst] == null;
                }
                return end;
            }

            @Override
            public Object next() {
                array[indexfirst] = 1;
                indexfirst++;
                return array[indexfirst - 1];
            }

            @Override
            public void remove() {
                if (indexend < array.length) {
                    array[indexend] = null;
                    indexend++;

                } else {
                    indexend = 0;
                    array[indexend] = null;
                    indexend++;
                }
            }
        };
    }

    @Override
    public boolean add(T t) {
        return super.add(t);
    }

    @Override
    public T peek() {
        return null;
    }


    @Override
    public boolean offer(Object o) {
        return false;
    }


    @Override
    public int size() {
        return array.length;
    }

    @Override
    public T poll() {
        return null;
    }

    public static void main(String[] args) {

        Test<Integer> myTest = new Test<Integer>(1, 0, 0);
        Iterator<Integer> iteratortest1 = myTest.iterator();

        System.out.println("test 1 добавление элемента в очередь");
        iteratortest1.hasNext();
        iteratortest1.next();
        System.out.println(Arrays.toString(myTest.array));

        System.out.println("test 2 удаление и добавление элемента");
        iteratortest1.remove();
        iteratortest1.hasNext();
        iteratortest1.next();
        System.out.println(Arrays.toString(myTest.array));

        System.out.println("test 3 добавление у удаление элементов в цикле(проходит 5 раз)");
        int a = 0;
        while (iteratortest1.hasNext() && a < 5) {
            System.out.println(iteratortest1.next());
            a++;
        }

        Test<Integer> myTest2 = new Test<Integer>(5, 2, 2);
        Iterator<Integer> iteratortest2 = myTest2.iterator();//ctrl+alt+v;

        System.out.println("Создание новой очереди");
        System.out.println(Arrays.toString(myTest2.array));
        System.out.println("Test 1 добавление элемента в индекс 2");
        iteratortest2.hasNext();
        iteratortest2.next();
        System.out.println(Arrays.toString(myTest2.array));
        System.out.println("Test 2 добавление элемента в индекс 3");
        iteratortest2.hasNext();
        iteratortest2.next();
        System.out.println(Arrays.toString(myTest2.array));
        System.out.println("Test 3 удаление элемента с индексом 2");
        iteratortest2.remove();
        System.out.println(Arrays.toString(myTest2.array));
    }
}
