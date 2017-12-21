package more;

public class MyGenericClass {
    public static void main(String[] args) {
        MyGeneric<String> stringGeneric = new MyGeneric<>();
        System.out.println(stringGeneric.getT());

        stringGeneric.getVoidFirst("one ", "two");
        System.out.println(stringGeneric.getFirst("one", "two"));

        String st = stringGeneric.getFirst("1.1");
        System.out.println(st);
    }
}

class MyGeneric<T> {
    private T t;

    public MyGeneric() {
        this.t = null;
    }

    public MyGeneric(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void getVoidFirst(T... a) { // generic void method
        System.out.println(a[0]);
    }

    public <T> T getFirst(T... a) { // generic method
        return a[0];
    }

    /*
    Bounds for Type Variable
    Sometimes, a class or a method need to place restrictions on type variables.
    We don't know is the class which T belong has a compareTo - can have error if class did'nt impl. Comparable interface
    To correct comparable two variable we should restrict T to a class that implements the Comparable interface

    <T expends BoundingType>
    T and BoundingType can be either a class or an interface
     */
    public <T extends Comparable> T min(T... a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) < 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }
}



