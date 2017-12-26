package topic1_07;

/*
3.10 Реализация интерфейса Comparable

Создать класс Circle, который реализует интерфейс Comparable.
Большей считается окружность с большим радиусом.
Осуществить сортировку массива объектов типа Circle.
 */

import java.util.Arrays;

public class Task10Comparable {
    public static void main(String[] args) {
        Circle a = new Circle(5);
        Circle b = new Circle(4);
        System.out.println(a.compareTo(b));

        Circle[] circles = {new Circle(1), new Circle(3), new Circle(2)};
        Arrays.sort(circles);
        System.out.println(Arrays.toString(circles));
    }
}

class Circle<T extends Circle<T>> implements Comparable<T> {
    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(T o) {
        return Double.compare(this.radius, o.getRadius());
    }

     int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "radius: " + radius;
    }
}
