package topic1_05;

/**
 * Created by Dmitry Titorenko on 31.01.2016.
 * <p>
 * Квадратное уравнение
 * Спроектировать класс для решения квадратного уравнения.
 */
public class Task3QuadraticEquation {
    public static void main(String[] args) {
        QuadraticEquation test1 = new QuadraticEquation(2, 5, 3);
        test1.solve();
        System.out.println(test1.x1 + "" + test1.x2);
    }
}

class QuadraticEquation {
    private int a;
    private int b;
    private int c;
    public double x1;
    public double x2;

    QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        double d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
        } else if (d == 0)
            x1 = x2 = -b / 2 * a;
        else System.out.println("D<0");
    }
}
