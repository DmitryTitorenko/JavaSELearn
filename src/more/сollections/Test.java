package more.сollections;

import java.util.ArrayList;

/**
 * @author Dmitry Titorenko on 11.03.2018
 */
public class Test {
    public static void main(String[] args) {

        try {
            String value = "29.1";
            System.out.println((Float.valueOf(value) + 1.0) == 30.1);
            System.out.println((Double.valueOf(value) + 1.0) == 30.1);
            System.out.println(Float.valueOf(value)/0);
            System.out.println(Double.valueOf(value)/0);
        }
        catch (NumberFormatException ex) {
            System.out.println("NumberFormatException");
        }
        catch (ArithmeticException ex) {
            System.out.println("ArithmeticException");
        }



        System.out.println("method() returned " + method());
    }


    static int method() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
            try {
                if (i == 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Exception!");
                return i;
            } finally {
                System.out.println("Finally block");
            }
        }
        int e=29;

        return -1;
    }

}

class A {
    static {
        i = 2;
    }
    static int i = 1;
};





