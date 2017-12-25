package topic1_07;

/*
3.6 Обобщенный класс
Создать обобщенный класс для хранения произвольных данных в массиве.
Реализовать функцию добавления элемента в конец массива, удаления элемента, добавления группы (другого массива) элементов.
 */

public class Task6GenericArray {
    public static void main(String[] args) {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(5);

        // test add elements
        for (int i = 0; i < 5; i++) {
            integerGenericArray.addElement(i);
        }

        System.out.println(integerGenericArray.toString());

        // test delete elements
        integerGenericArray.deleteElement(4);
        System.out.println(integerGenericArray.toString());
        integerGenericArray.deleteElement(3);
        System.out.println(integerGenericArray.toString());

        //test add array
        Integer[] e = new Integer[2];
        e[0] = 3;
        e[1] = 3;

        integerGenericArray.addArray(e);
        System.out.println(integerGenericArray.toString());
    }
}

class GenericArray<T> {
    private final Object[] objects;

    public GenericArray(int index) {
        this.objects = new Object[index];
    }

    public void addElement(T t) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = t;
                break;
            }
        }
    }

    public void deleteElement(int index) {
        if (objects.length - 1 >= index) {
            objects[index] = null;
        } else if (objects.length - 1 > index) {
            System.out.println("Index >  arrays length");
        }
    }

    public void addArray(T t[]) {
        int nullIndex = 0;
        for (Object object : objects) {// count empty index in array
            if (object == null) {
                nullIndex++;
            }
        }
        if (nullIndex >= t.length) {
            System.arraycopy(t, 0, objects, objects.length - nullIndex, t.length);
        } else {
            System.out.println("t.length > empty index in array");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : objects) {
            stringBuilder.append(" [").append(object).append("] ");
        }
        return stringBuilder.toString();
    }
}

