package topic1_05;

/**
 * Created by Dmitry Titorenko on 30.01.2016.
 */
public class Dihotomia {


    public static void main(String[] args) {
        Dihotomia d = new Dihotomia();
        System.out.println(d.solve(0, 10, 0.01));
    }

    public double f(double x) {
        return 5 * Math.pow(x, 2) - 4 * x + 1;
    }

    public double solve(double a, double b, double eps) {
        double x = (a + b) / 2;
        while (Math.abs(b - a) > eps) {
            if (f(x) * f(a) < 0)
                b = x;
            else
                a = x;
            x = (a + b) / 2;
        }
        return x;
    }

}

