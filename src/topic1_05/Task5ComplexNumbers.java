package topic1_05;

/**
 * Created by Dmitry Titorenko on 31.01.2016.
 * Комплексные числа
 * Создать класс для представления комплексного числа.
 * Реализовать конструкторы, функции сложения, вычитания, умножения, деления и умножения на константу.
 * Осуществить тестирование всех разработанных методов.
 */
public class Task5ComplexNumbers {
    public static void main(String[] args) {
        ComplexN a = new ComplexN(13, 1);
        ComplexN b = new ComplexN(7, -6);
        System.out.println(ComplexN.sum(a, b));
        System.out.println(ComplexN.subtraction(a, b));
        System.out.println(ComplexN.multiplication(a, b));
        System.out.println(ComplexN.division(a, b));
        System.out.println(ComplexN.multiplicationConstant(a, 2));
    }
}

class ComplexN {
    private double a;
    private double bi;

    public ComplexN(double a, double bi) {
        this.a = a;
        this.bi = bi;
    }

    public static ComplexN sum(ComplexN first, ComplexN second) {
        return new ComplexN(first.a + second.a, first.bi + second.bi);
    }

    public static ComplexN subtraction(ComplexN first, ComplexN second) {
        return new ComplexN(first.a - second.a, first.bi - second.bi);
    }

    public static ComplexN multiplication(ComplexN first, ComplexN second) {
        return new ComplexN(first.a * second.a + first.bi * second.bi * -1,
                first.bi * second.a + first.a * second.bi);
    }

    public static ComplexN division(ComplexN first, ComplexN second) {
        ComplexN numerator = new ComplexN(first.a * second.a + first.bi * second.bi,
                first.bi * second.a + first.a * second.bi * -1);

        double denominator = Math.pow(second.a, 2) + Math.pow(second.bi, 2);
        return new ComplexN(numerator.a / denominator, numerator.bi / denominator);
    }

    public static ComplexN multiplicationConstant(ComplexN first, int a) {
        return new ComplexN(first.a * a, first.bi * a);
    }

    @Override
    public String toString() {
        return a + " + " + bi + "i";
    }
}
