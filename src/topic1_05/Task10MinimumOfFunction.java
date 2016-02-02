package topic1_05;

/**
 * Created by Dmitry Titorenko on 02.02.2016.
 * <p>
 * Минимум функции
 * Реализовать программу, которая позволяет найти минимум некоторой функции на заданном интервале.
 * Алгоритм нахождения минимума заключается в последовательном переборе с заданным шагом точек интервала
 * и сравнении значений функции в текущей точке с ранее найденным минимумом.
 * Реализовать подход через использование абстрактных классов.
 */
public class Task10MinimumOfFunction {
    public static void main(String[] args) {
        MinimumOfFunction a = new MinimumOfFunction();
        a.getFunction(2, 2, -30);
        a.setStep(1);
        System.out.println(a.getMinimum(-6, 6));
    }
}

class MinimumOfFunction extends Function {
    private int a;//x^2
    private int b; //x
    private int c;
    private int step;

    @Override
    public void getFunction(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double setStep(int step) {
        return this.step = step;
    }

    @Override
    public double getMinimum(int a, int b) {
        double min = Math.pow(a, this.a) + this.b * a + this.c;
        for (int i = a; i < b; i += step) {
            double result = Math.pow(i, this.a) + this.b * i + this.c;
            if (result < min) {
                min = result;
            }
        }
        return min;
    }
}

abstract class Function {
    public abstract void getFunction(int a, int b, int c);

    public abstract double getMinimum(int a, int b);

    public abstract double setStep(int step);
}