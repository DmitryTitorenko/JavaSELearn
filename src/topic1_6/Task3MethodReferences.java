package topic1_6;
/*
3.3 Минимум функции с использованием ссылок на методы

Реализовать программу нахождения минимума функции с использованием ссылок на методы.
Использовать стандартные функциональные интерфейсы пакета java.util.function.
 */


public class Task3MethodReferences {

    public static void main(String[] args) {
        /*
            ContainingClass::staticMethodName
            containingObject::instanceMethodName
            ClassName::new
         */
        MyFunctionInterface mathMinOfFunction = MinimumOfFunction2::getMin;
        System.out.println(mathMinOfFunction.math(2, 10, 10, -10, 10, 1));

    }
}

class MinimumOfFunction2 {

    static public double getMin(int a, int b, int c, int startInterval, int endInterval, int step) {
        double min = Math.pow(a, 2) * startInterval + b * startInterval + c;
        for (int i = startInterval; i < endInterval; i += step) {
            double minTemp = Math.pow(a, 2) * i + b * i + c;
            if (minTemp < min) {
                min = minTemp;
            }
        }
        return min;
    }
}

@FunctionalInterface
interface MyFunctionInterface {
    double math(int a, int b, int c, int startInterval, int endInterval, int step);
}

