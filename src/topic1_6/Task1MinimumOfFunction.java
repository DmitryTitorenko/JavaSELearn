package topic1_6;

/*
 * <p>
 * Минимум функции
 * Реализовать программу, которая позволяет найти минимум некоторой функции на заданном интервале.
 * Алгоритм нахождения минимума заключается в последовательном переборе с заданным шагом точек интервала
 * и сравнении значений функции в текущей точке с ранее найденным минимумом (Метод сканирования).
 * Реализовать три подхода - через использование явного класса, безымянного класса и лямбда-выражения.
 */
public class Task1MinimumOfFunction {
    public static void main(String[] args) {
        MinimumOfFunction minimumOfFunction = new MinimumOfFunction();
        System.out.println(minimumOfFunction.getMin(2, 10, 10, -10, 10, 1));
        System.out.println(LambdaExpression.mathMinOfFunction.getMin(2, 10, 10, -10, 10, 1));
        System.out.println(MinOfFunctionAnonymousClass.mathMinOfFunction.getMin(2, 10, 10, -10, 10, 1));
    }
}

class MinimumOfFunction implements MathMinOfFunction {

    @Override
    public double getMin(int a, int b, int c, int startInterval, int endInterval, double step) {
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


class LambdaExpression {
    static MathMinOfFunction mathMinOfFunction = (int a, int b, int c, int startInterval, int endInterval, double step) -> {
        double min = Math.pow(a, 2) * startInterval + b * startInterval + c;
        for (int i = startInterval; i < endInterval; i += step) {
            double minTemp = Math.pow(a, 2) * i + b * i + c;
            if (minTemp < min) {
                min = minTemp;
            }
        }
        return min;
    };
}

class MinOfFunctionAnonymousClass {
    static MathMinOfFunction mathMinOfFunction = new MathMinOfFunction() {
        @Override
        public double getMin(int a, int b, int c, int startInterval, int endInterval, double step) {
            double min = Math.pow(a, 2) * startInterval + b * startInterval + c;
            for (int i = startInterval; i < endInterval; i += step) {
                double minTemp = Math.pow(a, 2) * i + b * i + c;
                if (minTemp < min) {
                    min = minTemp;
                }
            }
            return min;
        }
    };
}

@FunctionalInterface
interface MathMinOfFunction {
    double getMin(int a, int b, int c, int startInterval, int endInterval, double step);
}

