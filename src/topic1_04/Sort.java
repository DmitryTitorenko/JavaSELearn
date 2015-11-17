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
}
