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