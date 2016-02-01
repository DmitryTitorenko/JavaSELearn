package topic1_05;

/**
 * Created by Dmitry Titorenko on 28.01.2016.
 */
public class MyInstanseof {
    public static void main(String[] args) {
        First first = new First(1);
        First first1 = new First(1);
        System.out.println(first.equals(first1));
        Second second = new Second(1);
        System.out.println(first.equals(second));
        System.out.println(second.equals(first));
    }
}

class First {
    private int id;

    public First(int id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof First))
            return false;
        First first = (First) obj;
        return this.id == first.id;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[id=" + this.id + "]";
    }
}

class Second extends First {

    public Second(int id) {
        super(id);
    }
    // не переопределяем equals т.к. он нас устравивает-сравлнивает по id
}
