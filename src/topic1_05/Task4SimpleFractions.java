package topic1_05;

/**
 * Created by Dmitry Titorenko on 31.01.2016.
 * <p>
 * Простые дроби
 * Дополнить класс для представления простой дроби функциями перемножения дробей (статический метод)
 * и возведения дроби в целую степень (нестатический метод). Добавить в функции main() ввод данных с клавиатуры.
 */
public class Task4SimpleFractions {
    public static void main(String[] args) {
        SimpleFraction a = new SimpleFraction(2, 3);
        SimpleFraction b = new SimpleFraction(3, 4);
        System.out.println(SimpleFraction.a(a, b));
        a.pow(2);
        System.out.println(a);
    }
}

class SimpleFraction {
    public int numerator;
    public int denominator;
    public static int e;

    SimpleFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static SimpleFraction a(SimpleFraction a, SimpleFraction b) {
        SimpleFraction c = new SimpleFraction(a.numerator * b.numerator, a.denominator * b.denominator);
        return c;
    }

    public void pow(int pow) {
        this.numerator *= pow;
        this.denominator *= pow;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
