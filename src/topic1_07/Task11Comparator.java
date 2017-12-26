package topic1_07;

/*
Создать класс Triangle.
Треугольник задавать длинами сторон.
 Площадь треугольника в этом случае может быть вычислена по формуле Герона:

где a, b и c - длины сторон треугольника.
Осуществить сортировку массива треугольников по уменьшению площади.
Для определения признака сортировки использовать объект, реализующий интерфейс Comparator.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Task11Comparator {
    public static void main(String[] args) {
        Triangle[] triangles = {new Triangle(5, 4, 3),
                new Triangle(6, 5, 5),
                new Triangle(15, 13, 4)};

        System.out.println("before: "+Arrays.toString(triangles));

        Arrays.sort(triangles, new ComparatorTriangle());
        System.out.println("after:  "+Arrays.toString(triangles));

    }
}

class Triangle {
    private double square;

    Triangle(double a, double b, double c) {
        mathGeron(a, b, c);
    }

    private void mathGeron(double a, double b, double c) {
        double s = (a + b + c) / 2;
        this.square = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "square: " + square;
    }
}

class ComparatorTriangle implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        if (o1.getSquare() > o2.getSquare()) {
            return -1;
        } else if (o1.getSquare() < o2.getSquare()) {
            return 1;
        } else {
            return 0;
        }
    }
}
