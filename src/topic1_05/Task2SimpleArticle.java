package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 31.01.2016.
 * Создать класс с конструктором для описания товара (сохраняются название и цена)
 */
public class Task2SimpleArticle {

    public static void main(String[] args) {
        ArraysArticle arraysArticles = new ArraysArticle(5);

        arraysArticles.addArticle("Giant", 500);

        System.out.println(arraysArticles.toString());
        System.out.println(arraysArticles.getArticle(0).toString());
        arraysArticles.deleteArticle(0);
        System.out.println(arraysArticles.toString());
        System.out.println(arraysArticles.count());
    }
}

abstract class AbstractArraysOfArticle {
    public abstract void addArticle(String title, int prise);

    public abstract Object getArticle(int i);

    public abstract void deleteArticle(int i);

    public abstract int count();
}


class ArraysArticle extends AbstractArraysOfArticle {
    private Article article[];

    ArraysArticle(int i) {
        article = new Article[i];
    }

    @Override
    public void addArticle(String title, int prise) {
        if (article[0] == null) {
            article[0] = new Article(title, prise);
        } else {
            this.article = Arrays.copyOf(this.article, this.article.length + 1);
            article[article.length] = new Article(title, prise);
        }
    }

    @Override
    public Article getArticle(int i) {
        return article[i];
    }

    @Override
    public void deleteArticle(int i) {
        article[i] = null;
    }

    @Override
    public int count() {
        int countI = 0;
        for (int i = 0; i < article.length - 1; i++) {
            if (article[i] != null) {
                countI++;
            }
        }
        return countI;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < article.length - 1; i++) {
            if (article[i] == null) {
                stringBuilder.append(" null");
            } else {
                stringBuilder.append(article[i].toString());
            }
        }
        return stringBuilder.toString();
    }
}

class Article {
    private static int id = 0;
    private String title;
    private int prise;

    Article(String title, int prise) {
        this.title = title;
        this.prise = prise;
        this.id++;
    }

    @Override
    public String toString() {
        return "id: " + id + " title: " + title + " prise: " + prise;
    }
}
