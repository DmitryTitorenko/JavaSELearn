package more;

import java.util.function.BiFunction;

public class MyLambda {
    public static void main(String args[]) {
        int a = 5;

        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;

        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
        System.out.println(s.getClass());

        //    This is a functional interface and can therefore be used as
        // the assignment target for a lambda expression or method reference.
        BiFunction<Integer, Integer, Integer> some = (a1, a2) -> a1 * a2;
        System.out.println(some.apply(5, 5));
    }
}

/*
An informative annotation type used to indicate that an interface type declaration is intended
to be a functional interface as defined by the Java Language Specification
 */
@FunctionalInterface
interface Square {
    int calculate(int x);//functional interface has exactly one abstract method

    default int someDefault() {
        return 3;
    }

    static int someStatic() {
        return 2;
    }
}
