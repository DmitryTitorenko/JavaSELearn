package more;

import java.util.function.BiFunction;

public class MyLambda {

    private static int ee = 10; // can change this variable in lambda expression

    public static void main(String args[]) {
        int e = 10;  //try to change this variable in lambda expression (we can't do it)


        //    This is a functional interface and can therefore be used as
        // the assignment target for a lambda expression or method reference.
        BiFunction<Integer, Integer, Integer> some = (a1, a2) -> a1 * a2;
        System.out.println(some.apply(5, 5));

        // call standard from method
        int intArray[] = {5, 1};
        MyImplementComparator myImplementComparator = new MyImplementComparator();
        CompareNumb.comparingNumberValue(intArray, myImplementComparator);


        // call use lambda expression - we don't need to define the method  for providing the implementation
        CompareNumb.comparingNumberValue(intArray, (first, second) -> first - second);

        // declare interface variable  'myComparator' with refer to lambda expression, with define the method in interface
        MyComparator myComparator = (first, second) -> first - second;
        CompareNumb.comparingNumberValue(intArray, myComparator);

        int result = myComparator.compare(4, 1);
        System.out.println(result);

        // code block
        myComparator = (first, second) -> {
            //e=50;     can't change  method variable
            ee = 30; // can change  class field
            return first - second + ee;
        };

        myComparator.compare(3, 1);
        System.out.println("ee " + ee); //ee=30


        // call use method references
        CompareNumb.comparingNumberValue(intArray, myImplementComparator::compare);


    }
}


class CompareNumb {
    public static void comparingNumberValue(int[] i, MyComparator myComparator) {
        if (myComparator.compare(i[0], i[1]) > 0) {
            System.out.println("(i[0] > i[1])");
        }
    }
}


// Don't uses this class if we use lambda
class MyImplementComparator implements MyComparator {
    @Override
    public int compare(int first, int second) {
        return first - second;
    }
}

// Java provides an annotation @FunctionalInterface, which is used to declare an interface as functional interface.
@FunctionalInterface
interface MyComparator {
    int compare(int first, int second);// An interface which has only one abstract method is called functional interface
}
