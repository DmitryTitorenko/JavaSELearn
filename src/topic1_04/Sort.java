package topic1_04;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitry Titorenko on 09.11.2015.
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(studidSorting(array)));
        fillArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    private static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-10, +11);//ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        return array;
    }

    private static int[] studidSorting(int[] array) {
        int a1;
        int a2;
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    a1 = array[i];
                    a2 = array[i + 1];
                    array[i] = a2;
                    array[i + 1] = a1;
                    end = false;
                    break;
                }
            }
        }
        return array;
    }

    private static int[] bubbleSort(int[] array) {
        int a1;
        int a2;
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    a1 = array[i];
                    a2 = array[i + 1];
                    array[i] = a2;
                    array[i + 1] = a1;
                    end = false;
                }
            }
        }
        return array;
    }
    private static int[] selectionSort(int[] a) {
        int tempIndex = 0;
        int tempValue;
        boolean change = false;
        for (int i = 0; i < a.length; i++) {
            tempValue = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < tempValue) {
                    tempValue = a[j];
                    tempIndex = j;
                    change = true;
                }
            }
            if (change) {
                int temp1 = a[i];
                a[i] = a[tempIndex];
                a[tempIndex] = temp1;
            }
            change = false;
        }
        return a;
    }

    private static int[] InsertSort(int[] a) {
        int firstIndex;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                firstIndex = a[j];
                a[j] = a[j - 1];
                a[j - 1] = firstIndex;
            }
        }

        return a;
    }
}
