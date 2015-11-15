package topic1_04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dmitry Titorenko on 07.11.2015.
 *
 * 5 Суммы элементов*
 * В функции main() проинициализировать одномерный массив целых чисел случайными значениями.
 * Создать функцию, которая принимает в качестве параметра массив и выводит на экран сумму
 * элементов массива от первого элемента до элемента с номером k, а также сумму элементов от
 * элемента с номером k+1 до последнего. Функция возвращает true, если первая сумма больше,
 * и false в противном случае. Результат вывести на экран.
 */
public class Task5SumOfElements {
    public static int k;
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        System.out.println("Введите размерность массива");
        int [] a=new int[s.nextInt()];

        System.out.println("Введите kй элемент");
        k=s.nextInt();

        Random random=new Random();
        for (int i = 0; i <a.length; i++) {
            //a[i]=(int)(Math.random()* 10);
            a[i]=random.nextInt(10);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(method(a));

    }
    public static  boolean method(int [] a){
        int sumbeforek=0;
        int sumafterk=0;
        boolean b;
        for (int i = 0; i <a.length; i++) {
            if(i<k-1){
                sumbeforek+=a[i];
            }
            else {
                sumafterk+=a[i];
            }
        }
        if (sumbeforek>sumafterk){
            b=true;
        }
        else {
            b=false;
        }
        return b;
    }
}
