package more;

public class MyGenericClass {
    public static void main(String[] args) {
        Generic<String> stringGeneric = new Generic<>();
        System.out.println(stringGeneric.getT());
        stringGeneric = new Generic<>("String...");
        System.out.println(stringGeneric.getT());

        stringGeneric.getVoidFirst("one ", "two");
        System.out.println(stringGeneric.getFirst("one", "two"));

        String st = stringGeneric.<String>getFirst("1.1");// can place the actual types in angle brackets
        System.out.println(st);

        st = stringGeneric.getFirst("1");// can omit the <String> type parameter
        System.out.println(st);

        Generic<CPU> cpuGeneric = new Generic<>();
        CPU cpu = new CPU();
    }
}

class Generic<T> {
    private T t;

    public Generic() {
        this.t = null;
    }

    public Generic(T t) {
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



