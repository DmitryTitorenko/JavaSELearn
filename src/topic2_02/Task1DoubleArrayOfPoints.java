package topic2_02;
/*
3.1 Реализация массива точек списком вещественных чисел*

Реализовать функциональность абстрактного класса AbstractArrayOfPoints,
приведенного в примере предыдущего занятия, через использование списка вещественных чисел.
 Каждая пара чисел в списке должна соответствовать точке.
 */

import topic1_05.AbstractArrayOfPoints;

import java.util.ArrayList;
import java.util.List;

public class Task1DoubleArrayOfPoints {
    public static void main(String[] args) {
        DoubleArrayOfPoints doubleArrayOfPoints = new DoubleArrayOfPoints();
        doubleArrayOfPoints.test();
        System.out.println(doubleArrayOfPoints.getPointIndex(1));
        doubleArrayOfPoints.setPoint(1, 8, 9);
        System.out.println(doubleArrayOfPoints);
    }
}

class DoubleArrayOfPoints extends AbstractArrayOfPoints {

    private static List<Integer> integers = new ArrayList<>();

    public String getPointIndex(int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x: " + integers.get(index * 2));
        stringBuilder.append(" y: " + integers.get(index * 2 + 1));
        return stringBuilder.toString();
    }

    @Override
    public void setPoint(int i, int x, int y) {
        integers.set(i * 2, x);
        integers.set(i * 2 + 1, y);

    }

    @Override
    public int getX(int i) {
        return integers.get(i * 2);
    }

    @Override
    public int getY(int i) {
        return integers.get(i * 2 + 1);
    }

    @Override
    public int getAllCountPoint() {
        return integers.size() / 2;
    }

    @Override
    public void addPoint(int x, int y) {
        integers.add(Integer.valueOf(x));
        integers.add(Integer.valueOf(y));

    }

    @Override
    public void deleleteLastPoint() {
        integers.remove(integers.size() - 1);

    }

    @Override
    public void sortX() {
        super.sortX();
    }

    @Override
    public void sortY() {
        super.sortY();
    }

    @Override
    public String toString() {
        return integers.toString();
    }

    @Override
    public void test() {
        super.test();
    }
}