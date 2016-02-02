package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 29.01.2016.
 * <p>
 * Реализован обстрактный класс - массив точек и для него две реализации -  с помощью класса и двух массивов
 */
public abstract class AbstractArrayOfPoints {
    public abstract void setPoint(int i, int x, int y);

    public abstract int getX(int i);

    public abstract int getY(int i);

    public abstract int getAllCountPoint();

    public abstract void addPoint(int x, int y);

    public abstract void deleleteLastPoint();

    public void sortX() {//сортировка по убыванию
        boolean end;
        do {
            end = false;
            for (int i = 0; i < getAllCountPoint() - 1; i++) {
                if (getX(i) > getX(i + 1)) {
                    int a = getX(i);
                    int b = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, a, b);
                    end = true;
                }
            }
        }
        while (end);
    }

    public void sortY() {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < getAllCountPoint() - 1; i++) {
                if (getY(i) > getY(i + 1)) {
                    int a = getX(i);
                    int b = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, a, b);
                    end = false;
                }
            }
        }
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < getAllCountPoint(); i++) {
            s += "i: " + i + " x:" + getX(i) + " y " + getY(i) + "\n";
        }
        return s;
    }

    public void test() {
        addPoint(22, 45);
        addPoint(4, 11);
        addPoint(30, 5);
        addPoint(-2, 48);

        System.out.println(this);

        sortX();
        System.out.println(this);
        sortY();
        System.out.println(this);
        deleleteLastPoint();
        System.out.println(this);

    }
}

class ArrayOfPointObjects extends AbstractArrayOfPoints {
    private Point[] point = {};

    @Override
    public void setPoint(int i, int x, int y) {
        point[i] = new Point(x, y);
    }

    @Override
    public int getX(int i) {
        return point[i].getX();
    }

    @Override
    public int getY(int i) {
        return point[i].getY();
    }

    @Override
    public int getAllCountPoint() {
        return point.length;
    }

    @Override
    public void addPoint(int x, int y) {
        Point[] ggg = Arrays.copyOf(point, point.length + 1);
        ggg[getAllCountPoint()] = new Point(x, y);
        point = ggg;
    }

    @Override
    public void deleleteLastPoint() {
        point = Arrays.copyOf(point, getAllCountPoint() - 1);
    }

    public static void main(String[] args) {
        new ArrayOfPointObjects().test();
    }

}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ArrayWithTwoArrays extends AbstractArrayOfPoints {
    private int[] ax = {};
    private int[] ay = {};

    public static void main(String[] args) {
        new ArrayWithTwoArrays().test();
    }

    @Override
    public void setPoint(int i, int x, int y) {
        ax[i] = x;
        ay[i] = y;
    }

    @Override
    public int getX(int i) {
        return ax[i];
    }

    @Override
    public void deleleteLastPoint() {
        int[] xx = Arrays.copyOf(ax, ax.length - 1);
        int[] yy = Arrays.copyOf(ay, ay.length - 1);
        ax = xx;
        ay = yy;
    }

    @Override
    public void addPoint(int x, int y) {
        int[] xx = Arrays.copyOf(ax, ax.length + 1);
        int[] yy = Arrays.copyOf(ay, ay.length + 1);
        xx[getAllCountPoint()] = x;
        yy[getAllCountPoint()] = y;
        ax = xx;
        ay = yy;
    }

    @Override
    public int getAllCountPoint() {
        return ax.length;
    }

    @Override
    public int getY(int i) {
        return ay[i];
    }
}
