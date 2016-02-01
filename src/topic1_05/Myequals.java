package topic1_05;


/**
 * Created by Dmitry Titorenko on 09.01.2016.
 */
public class Myequals {
    public static void main(String[] args) {
        B b1 = new B("a", "a");
        B b2 = new B("a", "a");
        B b3 = b1;
        System.out.println("b1.equals(b2)" + b1.equals(b2));
        System.out.println("b1.equals(b3 " + b1.equals(b3));//false так как метод equals в классе B не переопределен и работает как "=="
        System.out.println("b1==b2 " + (b1 == b2));// операция “==” вернет true когда ссылки указывают на один и тот-же объект
        System.out.println("b1==b3 " + (b1 == b3));
        String a = "a";
        String b = "a";
        System.out.println("a.equals(b) " + a.equals(b));
        System.out.println("a==b " + (a == b));
        String a1 = new String("a");
        System.out.println("a.equals(a1)" + a.equals(a1));//true т.к. в String метод equals переопределен
        System.out.println("a==a1 " + (a == a1));
        D myd = new D("a", "a");
        D myd2 = new D("a", "a");
        System.out.println("myd==myd2 " + (myd == myd2));
        System.out.println("myd.equals(myd2) " + (myd.equals(myd2)));//true т.к. преопределили метод equals
    }
}

class B {
    public B(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    private String s1;
    private String s2;
}

class D {
    public D(String a, String b) {
        this.a = a;
        this.b = b;
    }

    private String a;
    private String b;

    @Override
    public boolean equals(Object obj) {

        //проверка на идентичность ссылок
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        //проверка, ссылается ли обьектная переменная obj на обьект D
        if (!(obj instanceof D))
            return false;
        D myd = (D) obj;
        //наследование - использование обьектов дочернего класса как обьект базового класса
        // обьект подкласса можно использовать вместо любого обьекта суперкласса
        //обьектная переменная суперкласса может ссылатся на любой обьект подкласса
        return a.equals(myd.a) && b.equals(myd.b);
    }
}
