package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 29.01.2016.
 */
public class MyClone implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human human = new Human(10, "go", new int[]{5, 5, 5, 5});
        Human a = (Human) human.clone();

    }
}

class Human implements Cloneable {
    private int age;
    private String name;
    private int[] some;

    Human(int age, String name, int[] some) {
        this.age = age;
        this.name = name;
        this.some = some;
    }

    @Override
    public String toString() {
        return age + " " + name + " " + Arrays.toString(some);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human human = (Human) super.clone();
        human.some = some.clone();
        return human;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Human human = new Human(10, "go", new int[]{5, 5, 5, 5});
        Human a = (Human) human.clone();
        System.out.println(a.toString());
        human.some[0] = 10;
        human.age = 99;
        System.out.println(human.toString());
        System.out.println(a.toString());
    }
}
