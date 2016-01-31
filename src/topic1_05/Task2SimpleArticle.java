package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 31.01.2016.
 * Создать класс с конструктором для описания товара (сохраняются название и цена)
 */
public class Task2SimpleArticle {
    private static int id = 0;
    private String title;
    private int prise;

    Task2SimpleArticle(String title, int prise) {
        this.title = title;
        this.prise = prise;
        id++;
    }

    @Override
    public String toString() {
        return "id:" + id + " title:" + title + " prise:" + prise;
    }
}


class ArraysArticle {
    private static Task2SimpleArticle[] a = {};

    public static void main(String[] args) {
        addArticle("Giant", 388);
        System.out.println(getId(0));

    }

    public static void addArticle(String title, int prise) {
        Task2SimpleArticle[] b = Arrays.copyOf(a, a.length + 1);
        b[a.length] = new Task2SimpleArticle(title, prise);
        a = b;
    }

    public static Task2SimpleArticle getId(int id) {
        return a[id];
    }
}
