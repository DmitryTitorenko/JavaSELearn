package more;

public class MyMethodReferences {
    public static void main(String[] args) {

        // Reference to a Static Method
        // ContainingClass::staticMethodName

        MySum mySum = MyImplementSum::MySumStatic;
        System.out.println(mySum.sum(1, 1));



        // Reference to an Instance Method
        // ContainingObject::instanceMethodName

        MyImplementSum myImplementSum = new MyImplementSum();
        MySum mySum1 = myImplementSum::MySumNotStatic;
        System.out.println(mySum1.sum(2, 2));

        MySum mySum2 = new MyImplementSum()::MySumNotStatic; // You can use anonymous object also
        System.out.println(mySum2.sum(2, 2));



        // Reference to a Constructor
        // ClassName::new

        Messageable messageable = Message::new;
        messageable.getMessage("one");

    }
}


class MyImplementSum {
    public static int MySumStatic(int a, int b) {
        return a + b;
    }

    public int MySumNotStatic(int a, int b) {
        return a + b;
    }

}

@FunctionalInterface
interface MySum {
    int sum(int a, int b);
}

@FunctionalInterface
interface Messageable {
    Message getMessage(String msg);
}

class Message {
    Message(String msg) {
        System.out.print(msg);
    }
}