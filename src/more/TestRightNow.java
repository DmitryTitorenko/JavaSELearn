package more;

import java.util.Arrays;
import java.util.Scanner;

public class TestRightNow {


    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        //  int count = s.nextInt();

        //int[] a = {10, 5, 8, 7, 1};
        //System.out.println(Arrays.toString(bubbleSort(a)));
        // System.out.println(Arrays.toString(selectionSort(a)));
        //System.out.println(Arrays.toString(InsertSort(a)));
    }

    private static int[] bubbleSort(int[] a) {
        int temp;
        boolean complete = false;
        while (!complete) {
            complete = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    complete = false;
                }
            }
        }
        return a;
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
